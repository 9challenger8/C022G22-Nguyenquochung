package com.hcg.framework.core.httpClientRemote;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Data
@Configuration
public class HttpClientConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "client-remote.url")
    public Map<ClientRemoteEnum, String> clientRemoteUrl()
    {
        return new HashMap<>();
    }
}
