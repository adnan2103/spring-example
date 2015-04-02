package com.cdk.spring;

import com.cdk.spring.entity.User;
import com.cdk.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSessionApplication implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

    public void run(String... args) {

        User user = null;
        user = new User("Zaman");
        userRepository.save(user);

        user = new User("Sadique");
        user.setId(2L);
        userRepository.save(user);

    }
}
