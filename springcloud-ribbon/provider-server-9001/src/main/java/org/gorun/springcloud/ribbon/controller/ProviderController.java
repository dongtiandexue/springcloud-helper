package org.gorun.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Running boy
 * @Description: 服务提供者
 * @date 2020/7/19 9:55
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "hi " + name + " ,i am from port: " + port;
    }
}
