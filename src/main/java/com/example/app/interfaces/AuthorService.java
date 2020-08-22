package com.example.app.interfaces;

import com.example.app.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();

    List<Author> findAuthorByAuthorName(String authorName);

    Author findAuthorByAuthorId(String authorId);

    Author save(Author author);

    Author update(Author author);

}
