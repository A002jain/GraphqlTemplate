package com.example.app.repository;

import com.example.app.model.Author;
import com.example.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {

    List<Book> findByAuthor(Author author); //auto implement the method

    Book findByBookName(String bookName);

    Book findByBookId(String bookId);
}
