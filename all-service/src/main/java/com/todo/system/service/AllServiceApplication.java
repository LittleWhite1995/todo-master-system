package com.todo.system.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AllServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllServiceApplication.class, args);
    }

}
