package com.springproject.spring2.services;

import com.springproject.spring2.domain.User;
import com.springproject.spring2.dto.UserDTO;
import com.springproject.spring2.repository.UserRepository;
import com.springproject.spring2.services.exception.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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

    //deletando id
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }


    public User Update(User obj){
        Optional<User> newObj = repo.findById(obj.getId());
        if (newObj.isPresent()){
            User existingUser = newObj.get();
            updateData(existingUser, obj);
            return repo.save(existingUser);
        } else {
            throw new ObjectNotFound("objeto não encontrado");
        }
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}
