package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Portion extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
}
