package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


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
    @JoinColumn(name = "branch_id",nullable = false)
    private Branch branch;
}
