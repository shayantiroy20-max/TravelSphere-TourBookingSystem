package com.tourapp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TourbookingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TourbookingApplication.class, args);
    }
}