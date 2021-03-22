package com.danielsilvalima.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.danielsilvalima.workshopmongo.domain.Post;
import com.danielsilvalima.workshopmongo.repository.PostRepository;
import com.danielsilvalima.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> 
            new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return this.repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return this.repository.fullSearch(text, minDate, maxDate);
    }

}
