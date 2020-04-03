package com.yang.rabbitmq;

import com.yang.rabbitmq.service.SendRabbitMq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private SendRabbitMq sendRabbitMq;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10000000; i++) {
            sendRabbitMq.sendMsg();
        }
    }

}
