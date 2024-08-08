package com.bigarson.model.exception;

public class AccountAlreadyExist extends RuntimeException {
    public AccountAlreadyExist() {
        super("already.exception.account");
    }
}
