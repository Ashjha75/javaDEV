package com.ashish.dev.springbootapplication1.repository;

import com.ashish.dev.springbootapplication1.entity.MongoEmpEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEmployRepository extends MongoRepository<MongoEmpEntity, ObjectId> {
}