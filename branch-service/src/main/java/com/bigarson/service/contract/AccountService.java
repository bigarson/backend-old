package com.bigarson.service.contract;

import com.bigarson.model.dto.AccountDTO;

import java.util.UUID;


public interface AccountService {

    AccountDTO getAccountByUserId(UUID userId);

}
