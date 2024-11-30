package com.devpaulojr.Spring_App.service;

import com.devpaulojr.Spring_App.model.Order;
import com.devpaulojr.Spring_App.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    //EndPoint findAll orders | repository
    @GetMapping
    public List<Order> findAll(){
        return repository.findAll();
    }

    //EndPoint findById orders | repository
    @GetMapping
    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
