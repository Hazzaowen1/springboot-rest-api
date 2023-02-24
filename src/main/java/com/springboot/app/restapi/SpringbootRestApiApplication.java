package com.springboot.app.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.springboot.app.restapi")
public class SpringbootRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestApiApplication.class, args);
    }

}
