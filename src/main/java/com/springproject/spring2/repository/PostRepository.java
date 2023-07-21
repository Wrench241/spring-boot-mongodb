package com.springproject.spring2.repository;

import com.springproject.spring2.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    //fazendo consulta com anotação Query
    @Query("{'title': { $regex: ?0 $options: 'i' }  }")
    List<Post> search(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);

}
