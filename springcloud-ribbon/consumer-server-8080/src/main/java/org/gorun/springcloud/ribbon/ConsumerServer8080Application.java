package org.gorun.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerServer8080Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServer8080Application.class, args);
    }

    /**
     * 1、提供一个 RestTemplate Bean 实例
     * 2、使用 @LoadBalanced 注解，就可以使用服务名代替ip地址，实现负载均衡调用
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
