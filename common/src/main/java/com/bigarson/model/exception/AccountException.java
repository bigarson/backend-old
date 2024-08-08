package com.bigarson.model.exception;

public abstract class AccountException extends RuntimeException{
    public AccountException(String message) {
        super(message);
    }
}
