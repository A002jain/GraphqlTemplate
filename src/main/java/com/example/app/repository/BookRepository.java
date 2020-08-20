package com.example.app.repository;

import com.example.app.model.Author;
import com.example.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {

    List<Book> findByAuthor(Author author); //auto implement the method

    Book findByBookName(String bookName);

    Book findByBookId(String bookId);

    @Transactional
    @Modifying
    @Query("delete from Book where bookId = ?1")
    void delete(String bookId);

    @Transactional
    @Modifying
    @Query("delete from Book where author_id = ?1")
    void deleteAll(String authorId);

    @Transactional
    @Modifying
    @Query("delete from Author where author_id = ?1")
    void deleteAuthor(String authorId);

}
