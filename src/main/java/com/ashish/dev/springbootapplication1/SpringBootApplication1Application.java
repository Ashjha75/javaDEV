package com.ashish.dev.springbootapplication1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.ashish.dev.springbootapplication1.repository")
public class SpringBootApplication1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication1Application.class, args);
        System.out.println("Working fine ✌️😎👌");
    }
//TODO: Just checking the todo

}
