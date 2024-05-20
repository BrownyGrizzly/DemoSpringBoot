package com.fashionboutique.fashionstore.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
@Getter
@Setter
public class CommonConfig {
    private String productUrl;
    private String productUsername;
    private String productPassword;
    private String productDriver;
    private String productDialect;
}
