package com.bigarson.service.impl;

import com.bigarson.model.dto.SubscriptionDTO;
import com.bigarson.model.entity.Subscription;
import com.bigarson.repository.SubscriptionRepository;
import com.bigarson.service.contract.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final ModelMapper modelMapper;

    @Override
    public SubscriptionDTO createSubscription(UUID accountId, UUID planId) {
        Timestamp current = new Timestamp(System.currentTimeMillis());
        Optional<Subscription> subscription = subscriptionRepository.findByAccountId(accountId);
        if (subscription.isPresent() && subscription.get().getEndDate().before(current)) {
            return modelMapper.map(subscription.get(), SubscriptionDTO.class);
        }
        Subscription subscriptionEntity = new Subscription();
        subscriptionEntity.setAccountId(accountId);
        subscriptionEntity.setPlanId(planId);
        subscriptionEntity = subscriptionRepository.save(subscriptionEntity);
        return modelMapper.map(subscriptionEntity, SubscriptionDTO.class);
    }
}
