package com.example.app.service;

import com.example.app.model.Author;
import com.example.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
