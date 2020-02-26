package com.shopping.userservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.shopping.userservice.domain.infrastructure")
@EntityScan(basePackages = "com.shopping.userservice.domain")
@ComponentScan(basePackages = {"com.shopping.userservice"})

@Import({SwaggerConfig.class})
public class AppConfig {
}
