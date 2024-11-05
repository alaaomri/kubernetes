package com.test.kubernetes;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration
public class TestContainersConfig {

    @Bean
    public PostgreSQLContainer<?> postgresContainer() {
        PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine")
                .withDatabaseName("bookmarkdb")
                .withUsername("user")
                .withPassword("password");
        postgres.start();
        return postgres;
    }
}
