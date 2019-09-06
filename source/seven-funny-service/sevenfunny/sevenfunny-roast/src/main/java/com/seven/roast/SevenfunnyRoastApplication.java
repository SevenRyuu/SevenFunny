package com.seven.roast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SevenfunnyRoastApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevenfunnyRoastApplication.class, args);
    }

    @Bean
    public com.seven.common.entity.util.IdWorker idWorker(){
        return new com.seven.common.entity.util.IdWorker(1,1);
    }


}
