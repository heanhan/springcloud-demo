package com.example.bank2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringcloudBank2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudBank2Application.class, args);
    }

}
