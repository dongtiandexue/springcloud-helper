package org.gorun.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Running boy
 * @Description: TODO
 * @date 2020/7/20 22:16
 */
@RestController
public class ConsumerController {

    private static final String SERVER_NAME = "PROVIDER-SERVER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/info/ribbon")
    public Object getInfoRibbon(@RequestParam(value = "name", defaultValue = "consumer") String name){
        String queryResult = restTemplate.getForObject("http://"+SERVER_NAME+"/hi?name="+ name, String.class);
        return queryResult;
    }

    @RequestMapping("/info/client")
    public Object getInfoClient(@RequestParam(value = "name", defaultValue = "consumer") String name){
        ServiceInstance instance = loadBalancerClient.choose(SERVER_NAME);
        String queryResult = restTemplate.getForObject("http://"+instance.getHost()+"/hi?name="+ name, String.class);
        return queryResult;
    }
}
