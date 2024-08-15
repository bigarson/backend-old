package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id",insertable = false, updatable = false)
    private Menu menu;
    @Column(nullable = false,unique = true,name = "menu_id")
    private UUID menuId;
}
