package com.irisi.reportingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasperConfig {
    @Bean
    public SimpleReportFiller reportFiller() {
        return new SimpleReportFiller();
    }

    @Bean
    public SimpleReportExporter simpleReportExporter() {
        return new SimpleReportExporter();
    }
}
