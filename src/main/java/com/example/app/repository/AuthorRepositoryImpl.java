package com.example.app.repository;

import com.example.app.model.Author;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public List<Author> findAll() {
        Author author = new Author();
        author.setAuthorId("a1");
        author.setAuthorName("JK Rowling");
        return Arrays.asList(author,author);
    }
}
