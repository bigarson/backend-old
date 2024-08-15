package com.bigarson.controller.contract;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.dto.WorkingTimeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/working-time")
public interface WorkingTimeController {

    @PostMapping("/{branchId}")
    ResponseEntity<BaseResponse<WorkingTimeDTO>> createWorkingTime(@AuthenticationPrincipal Jwt principal,
                                                                   @RequestBody WorkingTimeDTO workingTimeDTO,
                                                                   @PathVariable(name = "branchId") UUID branchId);

    @GetMapping("/{branchId}")
    ResponseEntity<BaseResponse<WorkingTimeDTO>> getWorkingTime(@AuthenticationPrincipal Jwt principal,
                                                                @PathVariable(name = "branchId") UUID branchId);

    @PutMapping("/{branchId}")
    ResponseEntity<BaseResponse<WorkingTimeDTO>> updateWorkingTime(@AuthenticationPrincipal Jwt principal,
                                                                   @RequestBody WorkingTimeDTO workingTimeDTO,
                                                                   @PathVariable(name = "branchId") UUID branchId);
}
