package com.bigarson.model.exception;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound() {
        super("notfound.exception.account");
    }
}
