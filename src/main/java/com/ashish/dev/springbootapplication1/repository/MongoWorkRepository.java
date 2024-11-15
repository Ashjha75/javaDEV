package com.ashish.dev.springbootapplication1.repository;

import com.ashish.dev.springbootapplication1.entity.MongoWorkEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoWorkRepository extends MongoRepository<MongoWorkEntity, ObjectId> {
}
