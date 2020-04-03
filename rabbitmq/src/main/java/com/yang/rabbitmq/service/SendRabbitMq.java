package com.yang.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendRabbitMq {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg() {
        System.out.println("rabbitmq正在发送数据........");
        amqpTemplate.convertAndSend("hello", "123456");
    }
}
