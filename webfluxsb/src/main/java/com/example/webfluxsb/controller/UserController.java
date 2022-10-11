package com.example.webfluxsb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.webfluxsb.model.User;
import com.example.webfluxsb.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService uService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody User user) {
        return uService.createUser(user);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getUsers() {
        return uService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Mono<User> getUser(@PathVariable String id) {
        return uService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public Mono<Void> delete(@PathVariable String id) {
        return uService.deleteUser(id);
    }
}
