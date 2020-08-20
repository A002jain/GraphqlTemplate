package com.example.app.repository;

import com.example.app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,String> {

    List<Author> findAuthorByAuthorName(String authorName);

}
