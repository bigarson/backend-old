package com.bigarson.controller.contract;

import com.bigarson.base.BaseResponse;
import com.bigarson.model.dto.AccountDTO;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/account")
public interface AccountController {

    @PostMapping()
    @RolesAllowed({"MANAGER"})
    ResponseEntity<BaseResponse<AccountDTO>> createAccount(@AuthenticationPrincipal Principal principal);

    @GetMapping()
    @RolesAllowed({"MANAGER"})
    ResponseEntity<BaseResponse<AccountDTO>> getAccount(@AuthenticationPrincipal Principal principal);


}
