package com.bigarson.model.exception;

public class AccountUnknownException extends RuntimeException {
    public AccountUnknownException() {
        super("exception-account-unknown");
    }
}
