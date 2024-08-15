package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.checkerframework.common.aliasing.qual.Unique;

import java.util.UUID;


@Data
@Entity
public class BranchWorkingTime extends BaseEntity {
    @Column
    private String monday;
    @Column
    private String tuesday;
    @Column
    private String wednesday;
    @Column
    private String thursday;
    @Column
    private String friday;
    @Column
    private String saturday;
    @Column
    private String sunday;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id",insertable = false, updatable = false)
    private Branch branch;
    @Column(nullable = false,unique = true,name = "branch_id")
    private UUID branchId;
}
