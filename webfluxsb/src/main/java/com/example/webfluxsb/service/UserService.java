package com.example.webfluxsb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webfluxsb.model.User;
import com.example.webfluxsb.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
   @Autowired
   private UserRepository userRepo; 

   public Mono<User> createUser(User u){
      return userRepo.save(u);
   }
   public Flux<User> getAllUsers(){
    return userRepo.findAll();
   }
   public Mono<User> getUserById(String id){
   return userRepo.findById(id);
   }
   public Mono<Void> deleteUser(String id){
     return userRepo.deleteById(id);
   }
}
