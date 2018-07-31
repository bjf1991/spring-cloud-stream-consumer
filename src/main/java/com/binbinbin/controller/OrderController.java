package com.binbinbin.controller;

import com.binbinbin.entity.OrderEntity;
import com.binbinbin.service.FeignService;
import com.binbinbin.service.OrderService;
import com.binbinbin.util.SnowflakeIdWorker;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bin on 2018/5/15.
 */
@RestController
@RequestMapping("/order/")
public class OrderController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private SnowflakeIdWorker idWorker;
    @Autowired
    private OrderService orderService;
    @Autowired
    private FeignService feignService;
    /**
     *
     * @return
     */
    @RequestMapping("order")
    public String order(OrderEntity order){
        return feignService.orderSave(order.getOrderNo(),order.getAmount());
    }

}
