package com.fstg.taxesejour.application.config;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SendMessage {

    private final Gson jsonConverter;

    public SendMessage(Gson jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public String buildMessage(Object payload) {
        MessageKafka messageKafka1 = new MessageKafka();
        messageKafka1.setDate(new Date());
        messageKafka1.setMs("E-TAXE-SEJOUR");
        messageKafka1.setPayload(payload);
        messageKafka1.setProcessName("CREATE TRIM");
        messageKafka1.setVersion("Version 1");
        return jsonConverter.toJson(messageKafka1);
    }
}
