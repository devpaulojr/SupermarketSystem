package com.devpaulojr.Spring_App.config;

import com.devpaulojr.Spring_App.model.Category;
import com.devpaulojr.Spring_App.model.Order;
import com.devpaulojr.Spring_App.model.Product;
import com.devpaulojr.Spring_App.model.User;
import com.devpaulojr.Spring_App.model.enums.OrderStatus;
import com.devpaulojr.Spring_App.repository.CategoryRepository;
import com.devpaulojr.Spring_App.repository.OrderRepository;
import com.devpaulojr.Spring_App.repository.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository; //Data access

    @Autowired
    private ProductRepository productRepository; //Data access

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "paulo", "paulo@gmail.com", "40028922", "152333");
        User u2 = new User(null, "clara", "clara@gmail.com", "80071525", "999944");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID ,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT ,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1 ,o2 ,o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

    }
}
