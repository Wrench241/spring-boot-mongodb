package com.springproject.spring2.Resources;

import com.springproject.spring2.domain.Post;
import com.springproject.spring2.domain.User;

import com.springproject.spring2.dto.UserDTO;
import com.springproject.spring2.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = services.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
        User obj = services.findById(id);
        return ResponseEntity.ok().body(obj.getPosts());
    }

    //endpont pra inserir um novo user
    //inserção retornando um obj vazio: void
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
        //convertendo Dto para user
        User obj = services.fromDTO(dto);
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    //requisição
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        //convertendo Dto para user
        User obj = services.fromDTO(objDto);
        obj.setId(id);
        obj = services.Update(obj);
        return ResponseEntity.noContent().build();
    }


}
