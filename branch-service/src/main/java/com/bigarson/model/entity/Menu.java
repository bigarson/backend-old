package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class Menu extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private String explanation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id",insertable = false, updatable = false)
    private Branch branch;
    @Column(nullable = false,unique = true,name = "branch_id")
    private UUID branchId;
}
