package com.devpaulojr.Spring_App.service;

import com.devpaulojr.Spring_App.model.User;
import com.devpaulojr.Spring_App.repository.UserRepository;
import com.devpaulojr.Spring_App.service.exceptions.DatabaseException;
import com.devpaulojr.Spring_App.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //EndPoint insert users | repository
    @PostMapping
    public User insert(User obj){
        return repository.save(obj);
    }

    //EndPoint delete users | repository
    @DeleteMapping
    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException error){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException error){
            throw new DatabaseException(error.getMessage());
        }
    }

    //EndPoint delete update | repository
    @PutMapping
    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updatedDate(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException error){
            throw new ResourceNotFoundException(id);
        }

    }

    private void updatedDate(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
