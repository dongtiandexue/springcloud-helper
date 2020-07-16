package org.gorun.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudHystrixEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixEureka7001Application.class, args);
    }

}
