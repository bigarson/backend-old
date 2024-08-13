package com.bigarson.controller.contract;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.dto.BranchDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/branch")
public interface BranchController {

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Şube ekleme",
            description = "Bu da açıklama!!"
    )
    ResponseEntity<BaseResponse<BranchDTO>> createBranch(@AuthenticationPrincipal Jwt principal,
                                                         @Valid @ModelAttribute BranchDTO branch);

    @PutMapping("/{branchId}")
    ResponseEntity<BaseResponse<BranchDTO>> updateBranch(@AuthenticationPrincipal Jwt principal,
                                                         @Valid @RequestBody BranchDTO branch,
                                                         @PathVariable("branchId") UUID branchId);

    @DeleteMapping("/{id}")
    ResponseEntity<BaseResponse<?>> deleteByBranchId(@AuthenticationPrincipal Jwt principal,
                                                     @Valid @PathVariable("id") UUID id);

    @GetMapping("/{id}")
    ResponseEntity<BaseResponse<BranchDTO>> getByBranchId(@Valid @PathVariable("id") UUID id);

    @GetMapping("/list")
    ResponseEntity<BaseResponse<List<BranchDTO>>> getAllBranchList(@AuthenticationPrincipal Jwt principal);

}
