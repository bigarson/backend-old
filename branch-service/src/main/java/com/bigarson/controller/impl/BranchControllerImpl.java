package com.bigarson.controller.impl;

import com.bigarson.base.BaseResponse;
import com.bigarson.controller.contract.BranchController;
import com.bigarson.model.dto.BranchDTO;
import com.bigarson.model.dto.BranchUpdateDTO;
import com.bigarson.service.contract.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BranchControllerImpl implements BranchController {


    private final BranchService branchService;

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> createBranch(Principal principal, BranchDTO branch) {
        BranchDTO branchDTO = branchService.create(principal,branch);
        return BaseResponse.ok(branchDTO,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> updateBranch(Principal principal, BranchUpdateDTO branch) {
        BranchDTO branchDTO = branchService.update(principal,branch);
        return BaseResponse.ok(branchDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<?>> deleteByBranchId(Principal principal, UUID id) {
        branchService.delete(principal,id);
        return BaseResponse.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<BranchDTO>> getByBranchId(UUID id) {
        BranchDTO branchDTO = branchService.getBranchByBranchId(id);
        return BaseResponse.ok(branchDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<BranchDTO>>> getAllBranchList(Principal principal) {
        List<BranchDTO> brancList = branchService.getBranchList(principal);
        return BaseResponse.ok(brancList,HttpStatus.OK);
    }
}
