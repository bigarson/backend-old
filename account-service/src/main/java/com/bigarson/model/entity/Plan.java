package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Plan extends BaseEntity {
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal pricePerMonth;
    @Column(nullable = false)
    private BigDecimal pricePerYear;
}
