package com.gopal.uberreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing  // this will enable jpa to Auditing data (when update and when create ....)
public class UberReviewServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberReviewServiceApplication.class, args);
    }

}
