package com.bigarson.service.contract;

import com.bigarson.model.dto.SubscriptionDTO;

import java.util.UUID;

public interface SubscriptionService {
    SubscriptionDTO createSubscription(UUID accountId, UUID planId);
}
