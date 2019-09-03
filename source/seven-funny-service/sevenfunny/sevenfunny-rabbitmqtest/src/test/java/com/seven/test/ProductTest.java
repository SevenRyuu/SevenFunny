package com.seven.test;

import com.seven.rabbitmqtest.SevenfunnyRabbitMQApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/3 1:12 PM
 * email  ：sevenryuu77@gmail.com
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SevenfunnyRabbitMQApplication.class)
public class ProductTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg1(){
        rabbitTemplate.convertAndSend("mqA", "直接模式测试");
    }

    /**
     * 分裂模式
     */
    @Test
    public void sendMsg2(){
        rabbitTemplate.convertAndSend("mqEx","","分裂模式测试");
    }

    /**
     * 主题模式
     */
    @Test
    public void sendMsg3(){
        rabbitTemplate.convertAndSend("mqTopic","log","主题模式模式测试");
    }
}
