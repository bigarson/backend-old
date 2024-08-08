package com.bigarson.model.exception;


public abstract class SecurityException extends RuntimeException{
    public SecurityException(String message) {
        super(message);
    }
}
