package com.springproject.spring2.Resources;

import com.springproject.spring2.domain.User;

import com.springproject.spring2.dto.UserDTO;
import com.springproject.spring2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @Autowired
    private UserServices services;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
       List<User> list = services.findAll();
       List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = services.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
