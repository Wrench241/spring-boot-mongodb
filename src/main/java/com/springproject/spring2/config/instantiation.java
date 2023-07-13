package com.springproject.spring2.config;

import com.springproject.spring2.domain.User;
import com.springproject.spring2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "maria", "maria@gmail.com");
        User alex = new User(null, "alex", "alex@gmail.com");
        User felipe = new User(null, "felipe", "felipe@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,felipe));
    }
}
