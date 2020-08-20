package com.example.app.service;

import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll(){ return bookRepository.findAll(); }

    public Book findBookByName(String bookName){ return bookRepository.findByBookName(bookName); }

    public Book findBookByBookId(String bookId){ return bookRepository.findByBookId(bookId); }

    public List<Book> findAllBookByAuthor(Author author){ return bookRepository.findByAuthor(author); }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
