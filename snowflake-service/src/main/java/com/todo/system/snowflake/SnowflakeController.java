package com.todo.system.snowflake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com-todo-sysytem-parent
 * @description: SnowflakeController
 * @author: littleWhite
 * @create: 2019/6/10 11:22
 **/
@RestController
public class SnowflakeController {

    private static final Logger logger = LoggerFactory.getLogger(SnowflakeServiceApplication.class);

    @Autowired
    SnowflakeDataService snowflakeDataService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String port;

    @Value("${snowflake.dataCenterId}")
    private String snowflake_dataCenterId;

    @Value("${snowflake.workerId}")
    private Long workerId;

    @Value("${snowflake.dataCenterId}")
    private Long dataCenterId;

    @RequestMapping("/generator/id")
    public String  generatorId(){
        return SnowflakeIdGenerator.getInstance(snowflakeDataService.getWorkerId(), snowflakeDataService.getDataCenterId()).nextId()+"";
    }

    @RequestMapping("/generator/id/long")
    public Long generatorIdOfLongType(){
        logger.info("生成ID服务的端口：{}, workId: {}, dateCenterId: {}", port, snowflakeDataService.getWorkerId(), snowflakeDataService.getDataCenterId());
        return SnowflakeIdGenerator.getInstance(snowflakeDataService.getWorkerId(), snowflakeDataService.getDataCenterId()).nextId();
    }

    @RequestMapping("/clear")
    public void clearCache() {
        while (stringRedisTemplate.opsForList().size("snowflakey_key") > 0){
            stringRedisTemplate.opsForList().leftPop("snowflakey_key");
        }

        System.out.println("success =========== ");
    }

}
