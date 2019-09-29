package com.example.bank1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpirngcloudBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpirngcloudBank1Application.class, args);
    }

}
