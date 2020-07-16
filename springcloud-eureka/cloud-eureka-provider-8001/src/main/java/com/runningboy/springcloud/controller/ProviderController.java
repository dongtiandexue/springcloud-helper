package com.runningboy.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Running boy
 * @Description: Provider Controller
 * @date 2020/6/14 9:39
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/info")
    public String info(@RequestParam("msg") String msg) {
        return "Eureka provider \t" +msg + " \t" + UUID.randomUUID();
    }
}
