package com.springproject.spring2.services;

import com.springproject.spring2.Resources.UserResources;
import com.springproject.spring2.domain.User;
import com.springproject.spring2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository repo;
    public List<User> findAll(){
        return repo.findAll();
    }
}
