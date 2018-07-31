package com.binbinbin.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bin on 2018/7/23.
 */
@FeignClient(name = "provider-demo")
public interface FeignService {
    @RequestMapping("/order/order")
    String orderSave(@RequestParam(value = "orderNo") String orderNo,
                     @RequestParam(value = "amount") Long amount);
}
