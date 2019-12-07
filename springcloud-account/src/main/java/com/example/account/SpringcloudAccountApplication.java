package com.example.account;

import com.example.commons.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcloudAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAccountApplication.class, args);
    }


    /**
     * 注入雪花算法的bean
     * @return
     */
    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}
