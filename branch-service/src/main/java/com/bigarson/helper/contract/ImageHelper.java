package com.bigarson.helper.contract;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface ImageHelper{
    String upload(MultipartFile image, UUID bucketName);
    void delete(String id, UUID bucketName);
    String getImageUrlById(String id, UUID bucketName);

}