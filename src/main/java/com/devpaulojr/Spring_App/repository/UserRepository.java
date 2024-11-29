package com.devpaulojr.Spring_App.repository;

import com.devpaulojr.Spring_App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
