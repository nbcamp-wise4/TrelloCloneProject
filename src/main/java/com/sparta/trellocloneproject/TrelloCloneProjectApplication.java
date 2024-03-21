package com.sparta.trellocloneproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.sparta.trellocloneproject.repository"})
@SpringBootApplication
public class TrelloCloneProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrelloCloneProjectApplication.class, args);
    }

}
