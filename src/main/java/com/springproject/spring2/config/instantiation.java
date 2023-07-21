package com.springproject.spring2.config;

import com.springproject.spring2.domain.Post;
import com.springproject.spring2.domain.User;
import com.springproject.spring2.dto.AuthorDTO;
import com.springproject.spring2.dto.ComentDTO;
import com.springproject.spring2.repository.PostRepository;
import com.springproject.spring2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        date.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepo.deleteAll();
        User maria = new User(null, "maria", "maria@gmail.com");
        User alex = new User(null, "alex", "alex@gmail.com");
        User felipe = new User(null, "felipe", "felipe@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, felipe));

        Post post1 = new Post(null, date.parse("19/07/2023"), "viagem", "dia de viagem", new AuthorDTO(maria));
        Post post2 = new Post(null, date.parse("19/07/2023"), "acampar", "muito bom", new AuthorDTO(maria));

        postRepo.saveAll(Arrays.asList(post1, post2));

        ComentDTO coment = new ComentDTO("vai ter festa hoje",date.parse("20/08/2023"), new AuthorDTO(alex));
        ComentDTO coment2 = new ComentDTO("sucesso a todos os devs",date.parse("20/08/2023"), new AuthorDTO(alex));
        ComentDTO coment3 = new ComentDTO("TI",date.parse("20/08/2023"), new AuthorDTO(alex));

        post1.getComents().addAll(Arrays.asList(coment, coment2));
        post2.getComents().addAll(Arrays.asList(coment3));

        postRepo.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);

    }
}
