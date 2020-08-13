package com.example.app.repository;

import com.example.app.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
}
