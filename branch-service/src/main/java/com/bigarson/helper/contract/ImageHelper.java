package com.bigarson.helper.contract;

import org.springframework.web.multipart.MultipartFile;

public interface ImageHelper{
    String upload(MultipartFile image);
    void delete(String id);
    String getImageUrlById(String id);

}