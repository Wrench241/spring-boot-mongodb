package com.springproject.spring2.services;

import com.springproject.spring2.domain.User;
import com.springproject.spring2.dto.UserDTO;
import com.springproject.spring2.repository.UserRepository;
import com.springproject.spring2.services.exception.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices extends User {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
      return repo.findById(id).orElseThrow(()
              -> new ObjectNotFound("objeto não encontrado"));
    }

    //metodo insert
    public User insert(User obj){
        return repo.insert(obj);
        //repositorio retornando obj
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.getId(), dto.getName(), dto.getEmail());
    }

}
