package com.bigarson.service.impl;

import com.bigarson.model.dto.AccountDTO;
import com.bigarson.model.entity.Account;
import com.bigarson.model.exception.AccountAlreadyExist;
import com.bigarson.model.exception.AccountNotFound;
import com.bigarson.repository.AccountRepository;
import com.bigarson.repository.SubscriptionRepository;
import com.bigarson.service.contract.AccountService;
import com.bigarson.service.contract.PlanService;
import com.bigarson.service.contract.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    private final PlanService planService;
    private final SubscriptionService subscriptionService;
    private final SubscriptionRepository subscriptionRepository;

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
