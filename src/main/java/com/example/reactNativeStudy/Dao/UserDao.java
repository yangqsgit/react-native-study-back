package com.example.reactNativeStudy.Dao;

import com.example.reactNativeStudy.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDao extends MongoRepository<User,Integer>{
}
