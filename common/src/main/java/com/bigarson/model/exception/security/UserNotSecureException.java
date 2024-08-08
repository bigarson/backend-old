package com.bigarson.model.exception.security;

import com.bigarson.model.exception.SecurityException;


public class UserNotSecureException extends SecurityException {
    public UserNotSecureException() {
        super("security.exception.userNotSecure");
    }
}
