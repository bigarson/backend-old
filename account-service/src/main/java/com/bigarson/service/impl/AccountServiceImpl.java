package com.bigarson.service.impl;

import com.bigarson.helper.SecurityUtils;
import com.bigarson.model.dto.AccountDTO;
import com.bigarson.model.entity.Account;
import com.bigarson.model.exception.AccountAlreadyExist;
import com.bigarson.model.exception.AccountNotFound;
import com.bigarson.repository.AccountRepository;
import com.bigarson.service.contract.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    @Override
    public AccountDTO createAccount(UUID userId) {
        if (accountRepository.findByUserId(userId).isPresent()) {
            throw new AccountAlreadyExist();
        }
        Account account = new Account();
        account.setUserId(userId);
        account = accountRepository.save(account);
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public AccountDTO getAccountByUserId(UUID userId) {
        Account account = accountRepository.findByUserId(userId).orElseThrow(AccountNotFound::new);
        return modelMapper.map(account, AccountDTO.class);
    }




    @Override
    public void setAccountDisable(UUID userId) {
        Account account = accountRepository.findByUserId(userId).orElseThrow(AccountNotFound::new);
        account.setActive(false);
        accountRepository.save(account);
    }

    @Override
    public void setAccountEnable(UUID userId) {
        Account account = accountRepository.findByUserId(userId).orElseThrow(AccountNotFound::new);
        account.setActive(true);
        accountRepository.save(account);
    }
}
