package com.irisi.reportingservice.consumer;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
@ToString
public class MessageKafka {
    private Object payload;
    private String processName;
    private String version;
    private String ms;
    private Date date;


}
