package com.bigarson.controller.impl;

import com.bigarson.base.BaseResponse;
import com.bigarson.controller.contract.PlanController;
import com.bigarson.model.dto.PlanDTO;
import com.bigarson.service.contract.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PlanControllerImpl implements PlanController {
    private final PlanService planService;

    @Override
    public ResponseEntity<BaseResponse<PlanDTO>> createPlan(Jwt principal, PlanDTO planDTO) {
        planDTO = planService.create(planDTO);
        return BaseResponse.ok(planDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse<?>> deletePlan(Jwt principal, UUID planId) {
        planService.deletePlan(planId);
        return BaseResponse.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<PlanDTO>>> planList() {
        List<PlanDTO> planDTOList = planService.getAll();
        return BaseResponse.ok(planDTOList, HttpStatus.OK);
    }
}
