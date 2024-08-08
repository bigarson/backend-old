package com.bigarson.service.impl;

import com.bigarson.AccountResponse;
import com.bigarson.AccountServiceGrpc;
import com.bigarson.ChangeAccountStatusRequest;
import com.bigarson.GetAccountRequest;
import com.bigarson.base.exception.account.AccountUnknownException;
import com.bigarson.model.dto.AccountDTO;
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

    @Override
    public AccountDTO createAccount(UUID userId) {
        throw new RuntimeException();
    }

    @Override
    public void setAccountDisable(UUID userId) {
        AccountResponse response = accountServiceBlockingStub.setAccountDisable(ChangeAccountStatusRequest.newBuilder().setUserId(userId.toString()).build());
        if (!response.getIsSuccess()) throw new AccountUnknownException();
    }

    @Override
    public void setAccountEnable(UUID userId) {
        AccountResponse response = accountServiceBlockingStub.setAccountEnable(ChangeAccountStatusRequest.newBuilder().setUserId(userId.toString()).build());
        if (!response.getIsSuccess()) throw new AccountUnknownException();
    }

}
