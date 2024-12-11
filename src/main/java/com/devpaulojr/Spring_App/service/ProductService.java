package com.devpaulojr.Spring_App.service;

import com.devpaulojr.Spring_App.model.Product;
import com.devpaulojr.Spring_App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    //EndPoint findAll product | repository
    @GetMapping
    public List<Product> findAll(){
        return repository.findAll();
    }

    //EndPoint findById product | repository
    @GetMapping
    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
