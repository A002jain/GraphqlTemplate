package com.example.app.repository;

import com.example.app.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;


public interface BookRepository {

    List<Book> findAll();
}
