package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Account extends BaseEntity {

    @Column(unique = true, nullable = false)
    private UUID userId;
    @Column(nullable = false,columnDefinition = "boolean default true")
    private boolean isActive = true;

}
