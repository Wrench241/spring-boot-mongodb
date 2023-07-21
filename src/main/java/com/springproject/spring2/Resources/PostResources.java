package com.springproject.spring2.Resources;

import com.springproject.spring2.Resources.util.URL;
import com.springproject.spring2.domain.Post;
import com.springproject.spring2.dto.AuthorDTO;
import com.springproject.spring2.services.PostServices;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> searchTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list = postServices.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
