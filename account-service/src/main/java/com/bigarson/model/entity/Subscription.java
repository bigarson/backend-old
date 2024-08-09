package com.bigarson.model.entity;

import com.bigarson.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Subscription extends BaseEntity {
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    private Account account;
    @Column(name = "account_id",nullable = false)
    private UUID accountId;
    @JoinColumn(name = "plan_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Plan.class, fetch = FetchType.LAZY)
    private Plan plan;
    @Column(name = "plan_id",nullable = false)
    private UUID planId;
    @CreationTimestamp
    private Timestamp startDate;
    @Column
    private Timestamp endDate;
}
