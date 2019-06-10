package com.todo.system.snowflake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SnowflakeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowflakeServiceApplication.class, args);
    }

}
