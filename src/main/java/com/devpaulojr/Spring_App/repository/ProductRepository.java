package com.devpaulojr.Spring_App.repository;

import com.devpaulojr.Spring_App.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
