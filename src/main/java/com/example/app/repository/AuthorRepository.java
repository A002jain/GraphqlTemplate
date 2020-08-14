package com.example.app.repository;

import com.example.app.model.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> findAll();
}
