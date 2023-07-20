package com.springproject.spring2.Resources;

import com.springproject.spring2.domain.Post;
import com.springproject.spring2.dto.AuthorDTO;
import com.springproject.spring2.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
    @Autowired
    private PostServices postServices;

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = postServices.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
}
