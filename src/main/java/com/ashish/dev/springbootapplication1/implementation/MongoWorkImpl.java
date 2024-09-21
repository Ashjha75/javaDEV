package com.ashish.dev.springbootapplication1.implementation;

import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import com.ashish.dev.springbootapplication1.service.MongoWorkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoWorkImpl implements MongoWorkService {
    @Override
    public List<MongoWorkModel> getAllWorks() {
        System.out.println("Inside getAllWorks");
        return null;
    }
}
