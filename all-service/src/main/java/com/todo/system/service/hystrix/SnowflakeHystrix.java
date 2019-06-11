package com.todo.system.service.hystrix;

import com.todo.system.service.service.SnowflakeServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class SnowflakeHystrix implements SnowflakeServiceFeign {
    @Override
    public Long generatorId() {
        return -1L;
    }
}
