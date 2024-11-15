package com.ashish.dev.springbootapplication1.service;


import com.ashish.dev.springbootapplication1.model.MongoWorkModel;
import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface MongoWorkService {
    List<MongoWorkModel> getAllWorks();

    String createWork(MongoWorkModel work);

    boolean updateWork(MongoWorkModel work);
//    boolean deleteWork(ObjectId id);
}
