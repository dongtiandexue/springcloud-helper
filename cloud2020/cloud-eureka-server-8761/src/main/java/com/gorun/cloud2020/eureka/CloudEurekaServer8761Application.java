package com.gorun.cloud2020.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServer8761Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServer8761Application.class, args);
    }

}
