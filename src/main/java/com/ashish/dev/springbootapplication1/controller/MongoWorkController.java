package com.ashish.dev.springbootapplication1.controller;

import com.ashish.dev.springbootapplication1.model.MongoEmplModel;
import com.ashish.dev.springbootapplication1.service.MongoWorkService;
import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/work")
    public String createWork(@RequestBody MongoWorkModel work) {
        return mongoWorkService.createWork(work);
    }

    @PutMapping("/work")
    public boolean updateWork(@RequestBody MongoWorkModel work) {
        return mongoWorkService.updateWork(work);
    }
}