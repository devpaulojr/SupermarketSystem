package com.devpaulojr.Spring_App.controller;

import com.devpaulojr.Spring_App.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    // GET | PUT | DELETE | CREATE
    @GetMapping
    public ResponseEntity<User> findAll(){

        User userTest = new User(1L, "Paulo Santana", "paulo@gmail.com", "40028922", "123456");

        return ResponseEntity.ok().body(userTest);
    }
}
