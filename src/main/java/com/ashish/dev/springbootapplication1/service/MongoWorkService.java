package com.ashish.dev.springbootapplication1.service;


import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface MongoWorkService {
    List<MongoWorkModel> getAllWorks();

    String createWork(MongoWorkModel work);

    Boolean updateWork(MongoWorkModel work);
//    boolean deleteWork(ObjectId id);
}
