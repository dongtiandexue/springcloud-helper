package org.gorun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Running boy
 * @Description:
 * @date 2020/7/11 15:57
 */
@RestController
@RequestMapping("/test")
public class HystrixTestController {

    /**
     * 模拟正常调用
     *
     * @return
     */
    @RequestMapping("/normal")
    public Object queryNormal() {
        return "正常调用";
    }

    /**
     * 模拟服务超时调用
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/timeout")
    @HystrixCommand(fallbackMethod = "timeOutFallback", commandProperties = {
            // 超时时间 500 毫秒
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
    })
    public Object queryTimeOut() throws InterruptedException {
        // 停止3s,模拟业务处理逻辑
        TimeUnit.SECONDS.sleep(3);
        return "调用超时";
    }

    public Object timeOutFallback(){
        return "调用失败 fallback, 服务超时";
    }

    /**
     * 模拟服务异常调用
     *
     * @return
     */
    @RequestMapping("/error")
    @HystrixCommand(fallbackMethod = "errorFallback")
    @HystrixCollapser(batchMethod = "errorFallback")
    public Object queryError() {
        int i = 1 / 0;
        return "调用异常";
    }

    public Object errorFallback(){
        return "调用失败 fallback, 服务异常";
    }

    //====================服务熔断=========================
    @RequestMapping("/circuitBreaker/{id}")
    @HystrixCommand(fallbackMethod = "circuitFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public Object circuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id 不能为负数 /(ㄒoㄒ)/~~");
        }
        return "调用成功 (*^_^*) id: " + id + " 流水号: " + UUID.randomUUID();
    }

    public Object circuitFallback(Integer id) {
        return "调用失败 fallback, 请稍后重试。。。";
    }

}
