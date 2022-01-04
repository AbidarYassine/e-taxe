package com.fstg.taxesejour.application.config;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class MessageKafka {
    private Object payload;
    private String processName;
    private String version;
    private String ms;
    private Date date;

}
