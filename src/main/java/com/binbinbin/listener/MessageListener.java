package com.binbinbin.listener;

import com.alibaba.fastjson.JSON;
import com.binbinbin.entity.OrderEntity;
import com.binbinbin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(DefaultProcess.class)
public class MessageListener {
    @Autowired
    private OrderService orderService;

    @StreamListener(DefaultProcess.INPUT1)
    public void input1(Message<OrderEntity> message) {
        System.err.println("【*** 消息接收input1 ***】" + JSON.toJSONString(message.getPayload()));
        orderService.save(message.getPayload());
    }
    @StreamListener(DefaultProcess.INPUT2)
    public void input2(Message<OrderEntity> message) {
        System.err.println("【*** 消息接收input2 ***】" + JSON.toJSONString(message.getPayload()));
        orderService.save(message.getPayload());
    }
}