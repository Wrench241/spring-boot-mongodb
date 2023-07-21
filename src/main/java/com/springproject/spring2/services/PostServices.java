package com.springproject.spring2.services;

import com.springproject.spring2.domain.Post;
import com.springproject.spring2.repository.PostRepository;
import com.springproject.spring2.services.exception.ObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepository postRepository;

    public Post findByID(String id){
        return postRepository.findById(id).orElseThrow(
                () -> new ObjectNotFound("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.search(text);
    }
}

