package com.devpaulojr.Spring_App.config;

import com.devpaulojr.Spring_App.model.Order;
import com.devpaulojr.Spring_App.model.User;
import com.devpaulojr.Spring_App.model.enums.OrderStatus;
import com.devpaulojr.Spring_App.repository.OrderRepository;
import com.devpaulojr.Spring_App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class UserConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository; //Data access

    @Autowired
    private OrderRepository orderRepository; //Data access

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "paulo", "paulo@gmail.com", "40028922", "152333");
        User u2 = new User(null, "clara", "clara@gmail.com", "80071525", "999944");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT ,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
