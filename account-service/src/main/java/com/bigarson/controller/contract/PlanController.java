package com.bigarson.controller.contract;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.dto.PlanDTO;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RequestMapping("/plan")
public interface PlanController {

    @PostMapping()
    @RolesAllowed({"ADMIN"})
    ResponseEntity<BaseResponse<PlanDTO>> createPlan(@AuthenticationPrincipal Jwt principal,
                                                     @Valid @RequestBody PlanDTO planDTO);
    @DeleteMapping("/{planId}")
    @RolesAllowed({"ADMIN"})
    ResponseEntity<BaseResponse<?>> deletePlan(@AuthenticationPrincipal Jwt principal,
                                                     @PathVariable("planId") UUID planId);

    @GetMapping
    ResponseEntity<BaseResponse<List<PlanDTO>>> planList();
}
