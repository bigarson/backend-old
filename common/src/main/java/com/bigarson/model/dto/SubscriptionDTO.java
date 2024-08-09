package com.bigarson.model.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class SubscriptionDTO {
    private UUID id;
    private UUID accountId;
    private UUID planId;
    private Timestamp startDate;
    private Timestamp endDate;

}
