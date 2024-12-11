package com.devpaulojr.Spring_App.service;

import com.devpaulojr.Spring_App.model.Category;
import com.devpaulojr.Spring_App.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    //EndPoint findAll category | repository
    @GetMapping
    public List<Category> findAll(){
        return repository.findAll();
    }

    //EndPoint findById category | repository
    @GetMapping
    public Category findById(Long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
