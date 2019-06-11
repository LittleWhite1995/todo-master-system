package com.todo.system.service.service;

import com.todo.system.service.config.FeignConfig;
import com.todo.system.service.hystrix.SnowflakeHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: com-todo-sysytem-parent
 * @description: SnowflakeServiceFeign
 * @author: littleWhite
 * @create: 2019/6/10 16:09
 **/
@FeignClient(value = "snowflake-service", configuration = FeignConfig.class, fallback = SnowflakeHystrix.class)
public interface SnowflakeServiceFeign {

    @RequestMapping("/generator/id/long")
    Long  generatorId();

}
