package com.runningboy.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Running boy
 * @Description: Consumer Controller
 * @date 2020/6/14 10:03
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/info")
    public String info(String msg) {
        return restTemplate.getForObject("http://provider-service/provider/info?msg=" + msg, String.class);
    }
}
