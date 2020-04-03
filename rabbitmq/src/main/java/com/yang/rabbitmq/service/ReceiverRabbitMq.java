package com.yang.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "hello")
public class ReceiverRabbitMq {

//    @RabbitHandler
    public void process(String message) {
        System.out.println("rabbitmq接收到数据........");
        System.out.println("receiverMsg:" + message);

    }
}
