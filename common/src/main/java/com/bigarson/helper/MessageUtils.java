package com.bigarson.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageUtils {

    private final MessageSource messageSource;

    public String getMessage(String code) {
        return messageSource.getMessage(code, null,"Bilinmeyen bir hata oluştu!",LocaleContextHolder.getLocale());
    }

}
