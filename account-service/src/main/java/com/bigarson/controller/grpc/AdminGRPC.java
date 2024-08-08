package com.bigarson.controller.grpc;

import com.bigarson.*;
import com.bigarson.helper.MessageUtils;
import com.bigarson.model.dto.AccountDTO;
import com.bigarson.service.contract.AccountService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.UUID;

@GrpcService
@RequiredArgsConstructor
public class AdminGRPC extends AccountServiceGrpc.AccountServiceImplBase {

    private final AccountService accountService;
    private final MessageUtils messageUtils;

    @Override
    public void createAccount(CreateAccountRequest request, StreamObserver<AccountResponse> responseObserver) {
        super.createAccount(request, responseObserver);
    }

    @Override
    public void setAccountDisable(ChangeAccountStatusRequest request, StreamObserver<AccountResponse> responseObserver) {
        try {
            UUID userId = UUID.fromString(request.getUserId());
            accountService.setAccountDisable(userId);
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(true).build());
        } catch (IllegalArgumentException e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage("illegal.argument.exception.uuid")).build());
        } catch (Exception e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage(e.getMessage())).build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void setAccountEnable(ChangeAccountStatusRequest request, StreamObserver<AccountResponse> responseObserver) {
        try {
            UUID userId = UUID.fromString(request.getUserId());
            accountService.setAccountEnable(userId);
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(true).build());
        } catch (IllegalArgumentException e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage("illegal.argument.exception.uuid")).build());
        } catch (Exception e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage(e.getMessage())).build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAccount(GetAccountRequest request, StreamObserver<AccountResponse> responseObserver) {

        try {
            UUID userId = UUID.fromString(request.getUserId());
            AccountDTO accountDTO = accountService.getAccountByUserId(userId);
            AccountResponse accountGRPC = AccountResponse.newBuilder()
                    .setId(accountDTO.getId().toString())
                    .setIsActive(accountDTO.isActive())
                    .setUserId(accountDTO.getUserId().toString())
                    .setIsSuccess(true)
                    .build();
            responseObserver.onNext(accountGRPC);
        } catch (IllegalArgumentException e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage("illegal.argument.exception.uuid")).build());
        } catch (Exception e) {
            responseObserver.onNext(AccountResponse.newBuilder().setIsSuccess(false).setMessage(messageUtils.getMessage(e.getMessage())).build());
        }
        responseObserver.onCompleted();
    }
}
