package com.fstg.taxesejour.infrastructure.messaging;

import java.util.Locale;

public interface LocalMessageReader {
    String getMessage(String code);

    void setLocale(Locale locale);
}

