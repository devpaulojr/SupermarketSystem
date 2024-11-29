package com.devpaulojr.Spring_App.config;

import com.devpaulojr.Spring_App.model.User;
import com.devpaulojr.Spring_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "paulo", "paulo@gmail.com", "40028922", "152333");
        User u2 = new User(null, "clara", "clara@gmail.com", "80071525", "999944");

        userRepository.saveAll(Arrays.asList(u1, u2));

    }
}
