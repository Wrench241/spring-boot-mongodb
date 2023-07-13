package com.springproject.spring2.Resources;

import com.springproject.spring2.domain.User;

import com.springproject.spring2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @Autowired
    private UserServices services;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
       List<User> list = services.findAll();
        return ResponseEntity.ok().body(list);

    }
}
