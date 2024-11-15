package com.ashish.dev.springbootapplication1.implementation;

import com.ashish.dev.springbootapplication1.entity.MongoWorkEntity;
import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import com.ashish.dev.springbootapplication1.repository.MongoWorkRepository;
import com.ashish.dev.springbootapplication1.service.MongoWorkService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MongoWorkImpl implements MongoWorkService {

    private final MongoWorkRepository mongoWorkRepository;

    public MongoWorkImpl(MongoWorkRepository mongoWorkRepository) {
        this.mongoWorkRepository = mongoWorkRepository;
    }

    @Override
    public List<MongoWorkModel> getAllWorks() {
        List<MongoWorkEntity> workEntities = mongoWorkRepository.findAll();
        return workEntities.stream().map(workEntity -> {
            MongoWorkModel work = new MongoWorkModel();
            BeanUtils.copyProperties(workEntity, work);
            return work;
        }).collect(Collectors.toList());
    }

    @Override
    public String createWork(MongoWorkModel work) {
        try {
            System.out.println(work);
            MongoWorkEntity workEntity = new MongoWorkEntity();
            BeanUtils.copyProperties(work, workEntity);
            mongoWorkRepository.save(workEntity);
            return "successfully added work😱";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while adding work: " + e.getMessage();
        }
    }
}