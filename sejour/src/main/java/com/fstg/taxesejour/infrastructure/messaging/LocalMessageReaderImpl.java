package com.fstg.taxesejour.infrastructure.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
public class LocalMessageReaderImpl implements  LocalMessageReader {

    private final MessageSource messageSource;

    public String getMessage(String code) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, locale);
    }

    @Override
    public void setLocale(Locale locale) {
        LocaleContextHolder.setLocale(locale);
    }
}

