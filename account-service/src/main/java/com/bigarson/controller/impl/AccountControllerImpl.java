package com.bigarson.controller.impl;

import com.bigarson.base.BaseResponse;
import com.bigarson.controller.contract.AccountController;
import com.bigarson.model.dto.AccountDTO;
import com.bigarson.service.contract.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountControllerImpl implements AccountController {
    private final AccountService accountService;


    @Override
    public ResponseEntity<BaseResponse<AccountDTO>> createAccount(Jwt principal) {
        AccountDTO response = accountService.createAccount(UUID.fromString(principal.getId()));
        return BaseResponse.ok(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse<AccountDTO>> getAccount(Jwt principal) {
        AccountDTO response = accountService.getAccountByUserId(UUID.fromString(principal.getId()));
        return BaseResponse.ok(response, HttpStatus.OK);
    }


}
