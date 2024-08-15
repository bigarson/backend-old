package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Portion extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",insertable = false, updatable = false)
    private Item item;
    @Column(nullable = false,unique = true,name = "item_id")
    private UUID itemId;
}
