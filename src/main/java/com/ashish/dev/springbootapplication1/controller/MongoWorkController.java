package com.ashish.dev.springbootapplication1.controller;

import com.ashish.dev.springbootapplication1.service.MongoWorkService;
import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoWorkController {

    private final MongoWorkService mongoWorkService;

    public MongoWorkController(MongoWorkService mongoWorkService) {
        this.mongoWorkService = mongoWorkService;
    }

    @GetMapping("/work")
    public List<MongoWorkModel> getAllWorks() {
        return mongoWorkService.getAllWorks();
    }
}