package com.todo.system.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(basePackages = "com.todo.system.orm")
@EnableEurekaClient
@SpringBootApplication
public class AllServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AllServiceApplication.class, args);
    }

}
