package com.example.app.repository;

import com.example.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        Book book = new Book();
        book.setBookId("1");
        book.setBookName("Harry Potter");
        book.setAuthor(authorRepository.findAll().stream().findFirst().orElse(null));
        return Arrays.asList(book,book);
    }
}
