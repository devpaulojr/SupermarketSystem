package com.devpaulojr.Spring_App.service;

import com.devpaulojr.Spring_App.model.User;
import com.devpaulojr.Spring_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    protected UserRepository repository; //Data access

    //EndPoint findAll users | repository
    @GetMapping
    public List<User> findAll(){
        return repository.findAll();
    }

    //EndPoint findById users | repository
    @GetMapping
    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
