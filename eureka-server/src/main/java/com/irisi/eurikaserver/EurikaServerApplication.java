package com.irisi.eurikaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurikaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurikaServerApplication.class, args);
    }

}
