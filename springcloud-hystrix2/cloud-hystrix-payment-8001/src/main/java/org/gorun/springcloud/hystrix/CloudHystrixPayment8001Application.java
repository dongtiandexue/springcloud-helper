package org.gorun.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker

public class CloudHystrixPayment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixPayment8001Application.class, args);
    }

}
