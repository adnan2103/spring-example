package com.cdk.spring;

import com.cdk.spring.entity.User;
import com.cdk.spring.entity.UserPrimaryKey;
import com.cdk.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSessionApplication implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        User user1 = new User(3L,"Naresh");
        User user2 = new User(3L,"Varma");
        User user3 = new User(3L,"Rohit");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        List<UserPrimaryKey> key = new ArrayList<>();
        key.add(new UserPrimaryKey(3L,"Varma"));
        key.add(new UserPrimaryKey(3L,"Naresh"));

        System.out.println("User Saved .");

        for(User user : userRepository.findAll(key)){
            System.out.println(" User is id : name "+user.getName()+" : "+user.getId());
        }


    }
}
