package com.bigarson.base;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false)
    private UUID id;
    @CreationTimestamp
    private Timestamp createdTime;
    @UpdateTimestamp
    private Timestamp updatedTime;
    @Column
    private Timestamp deletedTime;
    @Column
    private boolean isActive = true;
}