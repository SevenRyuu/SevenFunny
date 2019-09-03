package com.seven.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/3 9:17 PM
 * email  ：sevenryuu77@gmail.com
 */

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void executeSms(Map<String,String> map){
        System.out.println("手机号：" + map.get("mobiel"));
        System.out.println("验证码：" + map.get("verificationCode"));
    }
}
