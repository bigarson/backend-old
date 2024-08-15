package com.bigarson.helper.impl;

import com.bigarson.helper.contract.ImageHelper;
import io.minio.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ImageHelperImpl implements ImageHelper {

    private final MinioClient minioClient;

    @Override
    public String upload(MultipartFile image, UUID bucketName) {

        try {
            boolean bucketExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName.toString()).build());
            if (!bucketExist) {
                String policy = "{\n" +
                        "  \"Version\": \"2012-10-17\",\n" +
                        "  \"Statement\": [\n" +
                        "    {\n" +
                        "      \"Effect\": \"Allow\",\n" +
                        "      \"Principal\": \"*\",\n" +
                        "      \"Action\": [\n" +
                        "        \"s3:GetObject\"\n" +
                        "      ],\n" +
                        "      \"Resource\": [\n" +
                        "        \"arn:aws:s3:::" + bucketName + "/*\"\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName.toString()).build());
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(bucketName.toString()).config(policy).build());
            }
            String filename = UUID.randomUUID().toString();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName.toString())
                    .contentType(image.getContentType())
                    .stream(image.getInputStream(), image.getSize(), -1)
                    .object(filename)
                    .build());
            return "https://s3.bigarson.com/" + bucketName + "/" + filename;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(String id, UUID bucketName) {

    }

    @Override
    public String getImageUrlById(String id, UUID bucketName) {
        return "";
    }
}
