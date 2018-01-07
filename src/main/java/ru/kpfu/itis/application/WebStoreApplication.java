package ru.kpfu.itis.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"ru.kpfu.itis.controllers", "ru.kpfu.itis.services"})
@ComponentScan("ru.kpfu.itis")
@EnableJpaRepositories(basePackages = "ru.kpfu.itis.repositories")
@EntityScan("ru.kpfu.itis.models")
public class WebStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebStoreApplication.class, args);
    }
}
