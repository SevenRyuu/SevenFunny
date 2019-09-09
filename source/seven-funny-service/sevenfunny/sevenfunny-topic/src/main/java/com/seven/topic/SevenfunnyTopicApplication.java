package com.seven.topic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.seven.topic.dao.mapper")
public class SevenfunnyTopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevenfunnyTopicApplication.class, args);
    }

    @Bean
    public com.seven.common.entity.util.IdWorker idWorker(){
        return new com.seven.common.entity.util.IdWorker(1,1);
    }
}
