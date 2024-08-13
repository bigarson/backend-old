package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Branch extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column
    private String city;
    @Column
    private String district;
    @Column(nullable = false)
    private String zipcode;
    @Column(nullable = false)
    private String contactName;
    @Column(nullable = false)
    private String contactEmail;
    @Column(nullable = false)
    private String contactPhone;
    @Column(name = "account_id",nullable = false)
    private UUID accountId;
    @Column(name = "image_url")
    private String imageUrl;
}
