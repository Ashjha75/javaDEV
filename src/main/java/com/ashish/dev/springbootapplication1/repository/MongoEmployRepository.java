package com.ashish.dev.springbootapplication1.repository;

import com.ashish.dev.springbootapplication1.entity.MongoEmpEntity;
import com.ashish.dev.springbootapplication1.model.MongoEmplModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoEmployRepository extends MongoRepository<MongoEmpEntity, ObjectId> {
}