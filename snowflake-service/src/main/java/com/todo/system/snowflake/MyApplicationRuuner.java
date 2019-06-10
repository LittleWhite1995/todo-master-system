package com.todo.system.snowflake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: com-todo-sysytem-parent
 * @description: MyApplicationRuuner
 * @author: littleWhite
 * @create: 2019/6/10 15:50
 **/
@Component
class MyApplicationRuuner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    SnowflakeDataService snowflakeDataService;

    @Value("${snowflake.workerId}")
    private Long workerId;

    @Value("${snowflake.dataCenterId}")
    private Long dataCenterId;

    private static final String snowflake_key = "snowflakey_key";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> list = stringRedisTemplate.opsForList().range(snowflake_key, 0, 0);

        // 默认设置workerId = ${snowflake.workerId} = 1
        snowflakeDataService.setWorkerId(workerId);

        if (list == null || list.size() == 0) {
            stringRedisTemplate.opsForList().leftPush(snowflake_key, "1");
            snowflakeDataService.setDataCenterId(1L);
        }else {
            Long index = Long.valueOf(list.get(0));
            // index值不能大于7
            index = index + 1;

            if (index > 7)
                throw new RuntimeException("snowflake dataCenterId 大于7 不允许，请清空redis 中 snowflakey_key的值，或减少机器应用量");

            stringRedisTemplate.opsForList().leftPush(snowflake_key, index+"");
            snowflakeDataService.setDataCenterId(index);
        }
    }

}
