package com.springproject.spring2.Resources;

import com.springproject.spring2.domain.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/pai")
public class UserResources {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1","maria","maria@gmail.com");
        User jose = new User("2","jose","jose@gmail.com");
        User joao = new User("3","joao","joao@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria,jose,joao));
        return ResponseEntity.ok().body(list);

    }
}
