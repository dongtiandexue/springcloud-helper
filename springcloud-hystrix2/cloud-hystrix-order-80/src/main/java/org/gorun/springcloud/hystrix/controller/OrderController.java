package org.gorun.springcloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.gorun.springcloud.hystrix.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Running boy
 * @Description: 支付接口
 * @date 2020/7/11 15:57
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PaymentFeignService paymentService;

    /**
     * 模拟正常调用
     *
     * @return
     */
    @RequestMapping("/normal")
    public Object queryNormal() {
        return "订单侧调用支付侧结果：\n" + paymentService.queryNormal();
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
    public Object queryTimeOut() {
        return "订单侧调用支付侧结果：" + paymentService.queryTimeOut();
    }

    public Object timeOutFallback(){
        return "订单侧调用支付侧出现超时";
    }

    /**
     * 模拟服务异常调用
     *
     * @return
     */
    @RequestMapping("/error")
    @HystrixCommand(fallbackMethod = "errorFallback")
    public Object queryError() {
        return "订单侧调用支付侧结果：" + paymentService.queryError();
    }

    public Object errorFallback(){
        return "订单侧调用支付侧出现异常";
    }

}
