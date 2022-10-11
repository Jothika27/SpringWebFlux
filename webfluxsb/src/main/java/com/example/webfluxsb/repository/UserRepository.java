package com.example.webfluxsb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.webfluxsb.model.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
    
}
