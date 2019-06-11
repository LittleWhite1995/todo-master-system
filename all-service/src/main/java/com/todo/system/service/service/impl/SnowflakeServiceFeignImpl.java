package com.todo.system.service.service.impl;

import com.todo.system.service.service.SnowflakeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: com-todo-sysytem-parent
 * @description: SnowflakeServiceFeignImpl
 * @author: littleWhite
 * @create: 2019/6/10 16:21
 **/
@Service
public class SnowflakeServiceFeignImpl{

    @Autowired
    private SnowflakeServiceFeign snowflakeServiceFeign;

    public Long generatorId() {
        Long id = snowflakeServiceFeign.generatorId();
        if (id == -1)
            throw new RuntimeException("snowflakeServiceFeign.generatorId() is " + id + " ID生成服务可能中断");

        return id;
    }
}
