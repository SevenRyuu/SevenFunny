package com.seven.rabbitmqtest.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/3 1:24 PM
 * email  ：sevenryuu77@gmail.com
 */
@Component
@RabbitListener(queues = "mqC")
public class Customer3 {

    @RabbitHandler
    public void getMsg(String msg){
        System.out.println("mqC： "+ msg);
    }
}
