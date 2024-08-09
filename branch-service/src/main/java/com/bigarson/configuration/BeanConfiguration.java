package com.bigarson.configuration;


import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public MinioClient s3Client() {
        return MinioClient.builder()
                .endpoint("https://s3.bigarson.com")
                .credentials("bigarson", "12345678")
                .build();
    }
}
