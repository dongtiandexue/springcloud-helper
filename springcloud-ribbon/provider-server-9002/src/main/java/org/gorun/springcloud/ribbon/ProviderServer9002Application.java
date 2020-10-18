package org.gorun.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderServer9002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServer9002Application.class, args);
    }

}
