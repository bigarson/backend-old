package com.bigarson.controller.impl;

import com.bigarson.base.BaseResponse;
import com.bigarson.controller.contract.BranchController;
import com.bigarson.model.dto.BranchDTO;
import com.bigarson.service.contract.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BranchControllerImpl implements BranchController {

    private final BranchService branchService;

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> createBranch(Jwt principal, BranchDTO branch) {
        BranchDTO branchDTO = branchService.create(UUID.fromString(principal.getSubject()), branch);
        return BaseResponse.ok(branchDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> updateBranch(Jwt principal, BranchDTO branch, UUID branchId) {
        branch.setId(branchId);
        BranchDTO branchDTO = branchService.update(UUID.fromString(principal.getSubject()), branch);
        return BaseResponse.ok(branchDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<?>> deleteByBranchId(Jwt principal, UUID id) {
        branchService.delete(UUID.fromString(principal.getSubject()), id);
        return BaseResponse.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> getBranchById(UUID id) {
        BranchDTO branchDTO = branchService.getBranchByBranchId(id);
        return BaseResponse.ok(branchDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<BranchDTO>>> getAllBranchList(Jwt principal) {
        List<BranchDTO> brancList = branchService.getBranchListByUserId(UUID.fromString(principal.getSubject()));
        return BaseResponse.ok(brancList, HttpStatus.OK);
    }

}
