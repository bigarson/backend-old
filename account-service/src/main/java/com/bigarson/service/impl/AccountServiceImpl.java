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

import java.util.Optional;
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
        Optional<Account> account = accountRepository.findByUserId(userId);
        if (account.isPresent()) {
            return modelMapper.map(account.get(), AccountDTO.class);
        }
        Account newAccount = new Account();
        newAccount.setUserId(userId);
        newAccount = accountRepository.save(newAccount);
        return modelMapper.map(newAccount, AccountDTO.class);
    }

    @Override
    public AccountDTO getAccountByUserId(UUID userId) {
        Optional<Account> account = accountRepository.findByUserId(userId);
        if (account.isEmpty()) {
           return createAccount(userId);
        }
        return modelMapper.map(account.get(), AccountDTO.class);
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
