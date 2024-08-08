package com.bigarson.helper;

import com.bigarson.model.exception.security.UserNotSecureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static Authentication getUserId() {
        try {
            return SecurityContextHolder.getContext().getAuthentication();
        } catch (RuntimeException e) {
            throw new UserNotSecureException();
        }
    }
}
