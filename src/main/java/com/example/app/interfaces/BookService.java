package com.example.app.interfaces;

import com.example.app.model.Author;
import com.example.app.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findBookByName(String bookName);

    Book findBookByBookId(String bookId);

    List<Book> findAllBookByAuthor(Author author);

    Book save(Book book) ;

    Book update(Book book);

    Book delete(String bookId);

    void deleteAll(String authorId);

    List<String> getListOfBookNameByAuthor(Author author);
}
