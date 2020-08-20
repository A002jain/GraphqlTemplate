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

    public Book update(Book book){
        return bookRepository.save(merge(book));
    }

    public Book delete(String bookId){
        Book book = findBookByBookId(bookId);
        bookRepository.delete(bookId);
        return book;
    }

    public void deleteAll(String authorId){
        bookRepository.deleteAll(authorId);
        bookRepository.deleteAuthor(authorId);
    }

    private Book merge(Book book){
        Book orgBook = findBookByBookId(book.getBookId());
        if(book.getBookName() == null || book.getBookName().isEmpty()){
            book.setBookName(orgBook.getBookName());
        }
        if(book.getPages() == 0){
            book.setPages(orgBook.getPages());
        }
        if(book.getPrice() == 0.0d){
            book.setPrice(orgBook.getPrice());
        }
        if(book.getRating() == 0.0d){
            book.setRating(orgBook.getRating());
        }
        if(book.getAuthor() == null){
            book.setAuthor(orgBook.getAuthor());
        }else{
            if(book.getAuthor().getAuthorName() == null || book.getAuthor().getAuthorName().isEmpty()
                    || book.getAuthor().getAuthorId() == null || book.getAuthor().getAuthorId().isEmpty()){
                book.setAuthor(orgBook.getAuthor());
            }
        }
        return book;
    }
}
