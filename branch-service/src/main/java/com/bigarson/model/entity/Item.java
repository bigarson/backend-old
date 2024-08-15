package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Item extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal price;
    @Column
    private String imageUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",insertable = false, updatable = false)
    private Category category;
    @Column(nullable = false,unique = true,name = "category_id")
    private UUID categoryId;
}
