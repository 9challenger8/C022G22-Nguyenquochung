package com.hcg.framework.core.database;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.config.DatabaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class EBeanConfiguration {

    @Autowired
    CurrentUser currentUser;

    @Bean
    public DatabaseConfig ebeanServerConfig(DataSource dataSource) {
        DatabaseConfig config = new DatabaseConfig();
        config.setDataSource(dataSource);
        config.setCurrentUserProvider(currentUser);
        config.setDataTimeZone("UTC");
        config.loadFromProperties();
        return config;
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public Database ebeanDatabase(DatabaseConfig databaseConfig) {
        return DatabaseFactory.create(databaseConfig);
    }
}