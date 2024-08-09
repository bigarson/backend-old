package com.bigarson.service.impl;

import com.bigarson.AccountResponse;
import com.bigarson.AccountServiceGrpc;
import com.bigarson.GetAccountRequest;
import com.bigarson.model.dto.AccountDTO;
import com.bigarson.model.exception.AccountUnknownException;
import com.bigarson.service.contract.AccountService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @GrpcClient("account-service")
    private AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;


    @Override
    public AccountDTO getAccountByUserId(UUID userId) {
        AccountResponse response = accountServiceBlockingStub.getAccount(GetAccountRequest.newBuilder().setUserId(userId.toString()).build());
        if (!response.getIsSuccess()) throw new AccountUnknownException();
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(UUID.fromString(response.getUserId()));
        accountDTO.setId(UUID.fromString(response.getId()));
        accountDTO.setActive(response.getIsActive());
        return accountDTO;
    }
}
