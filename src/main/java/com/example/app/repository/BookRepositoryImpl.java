package com.example.app.repository;

import com.example.app.model.Book;

import java.util.Arrays;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {


    @Override
    public List<Book> findAll() {
        Book book = new Book();
        book.setBookId("1");
        book.setBookName("Harry Potter");
        return Arrays.asList(book,book);
    }
}
