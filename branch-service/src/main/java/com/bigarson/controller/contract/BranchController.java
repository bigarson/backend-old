package com.bigarson.controller.contract;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.dto.BranchDTO;
import com.bigarson.model.dto.BranchUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RequestMapping("/branch")
public interface BranchController {

    @PostMapping
    @Operation(
            summary = "Şube ekleme",
            description = "Bu da açıklama!!"
    )
    ResponseEntity<BaseResponse<BranchDTO>> createBranch(@AuthenticationPrincipal Principal principal,
                                                         @Valid @RequestBody BranchDTO branch);

    @PutMapping
    ResponseEntity<BaseResponse<BranchDTO>> updateBranch(@AuthenticationPrincipal Principal principal,
                                                         @Valid @RequestBody BranchUpdateDTO branch);

    @DeleteMapping("/{id}")
    ResponseEntity<BaseResponse<?>> deleteByBranchId(@AuthenticationPrincipal Principal principal,
                                                     @Valid @PathVariable("id") UUID id);

    @GetMapping("/{id}")
    ResponseEntity<BaseResponse<BranchDTO>> getByBranchId(@Valid @PathVariable("id") UUID id);

    @GetMapping("/list")
    ResponseEntity<BaseResponse<List<BranchDTO>>> getAllBranchList(@AuthenticationPrincipal Principal principal);

}
