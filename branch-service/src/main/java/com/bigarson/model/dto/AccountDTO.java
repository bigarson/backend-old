package com.bigarson.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class AccountDTO {
    private UUID id;
    private UUID userId;
    private boolean isActive;
}
