package com.todo.system.snowflake;

import org.springframework.stereotype.Service;

@Service
public class SnowflakeDataService {
    private Long dataCenterId;
    private Long workerId;

    public Long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(Long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }
}
