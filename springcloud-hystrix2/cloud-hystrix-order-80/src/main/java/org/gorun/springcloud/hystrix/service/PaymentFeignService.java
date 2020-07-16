package org.gorun.springcloud.hystrix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Running boy
 * @Description: 支付接口
 * @date 2020/7/11 15:57
 */
@FeignClient(name = "HYSTRIX-PAYMENT-SERVER")
public interface PaymentFeignService {

    /**
     * 模拟正常调用
     *
     * @return
     */
    @RequestMapping("/payment/normal")
    String queryNormal();

    /**
     * 模拟服务超时调用
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/payment/timeout")
    String queryTimeOut();

    /**
     * 模拟服务异常调用
     *
     * @return
     */
    @RequestMapping("/payment/error")
    String queryError();

}
