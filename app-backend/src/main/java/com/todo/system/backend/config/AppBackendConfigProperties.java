package com.todo.system.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppBackendConfigProperties {

    @Value("${custom.data.gateway.host}")
    private String gatewayHost;

    public String getGatewayHost() {
        return gatewayHost;
    }
}
