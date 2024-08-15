package com.bigarson.controller.impl;

import com.bigarson.base.BaseResponse;
import com.bigarson.controller.contract.WorkingTimeController;
import com.bigarson.model.dto.WorkingTimeDTO;
import com.bigarson.service.contract.WorkingTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RequiredArgsConstructor
@RestController
public class WorkingTimeControllerImpl implements WorkingTimeController{

    WorkingTimeService workingTimeService;

    @Override
    public ResponseEntity<BaseResponse<WorkingTimeDTO>> createWorkingTime(Jwt principal, WorkingTimeDTO workingTimeDTO, UUID branchId) {
        WorkingTimeDTO responseDTO = workingTimeService.createWorkingTime(branchId,workingTimeDTO);
        return BaseResponse.ok(responseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse<WorkingTimeDTO>> getWorkingTime(Jwt principal, UUID branchId) {
        WorkingTimeDTO responseDTO = workingTimeService.getWorkingTimeByBranchId(branchId);
        return BaseResponse.ok(responseDTO,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<WorkingTimeDTO>> updateWorkingTime(Jwt principal,WorkingTimeDTO workingTimeDTO, UUID branchId) {
        WorkingTimeDTO responseDTO = workingTimeService.updateWorkingTime(branchId,workingTimeDTO);
        return BaseResponse.ok(responseDTO, HttpStatus.OK);
    }
}
