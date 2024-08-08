package com.bigarson.service.contract;

import com.bigarson.model.dto.AccountDTO;

import java.util.UUID;

public interface AccountService {
    AccountDTO createAccount(UUID userId);
    AccountDTO getAccountByUserId(UUID userId);
    void setAccountDisable(UUID userId);
    void setAccountEnable(UUID userId);
}
