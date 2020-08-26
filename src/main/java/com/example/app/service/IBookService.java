package com.example.app.service;

import com.example.app.exception.GraphQLErrorHandler;
import com.example.app.interfaces.BookService;
import com.example.app.interfaces.Validation;
import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IBookService implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Validation validation;

    public IBookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){ return bookRepository.findAll(); }

    public Book findBookByName(String bookName){ return bookRepository.findByBookName(bookName.toUpperCase()); }

    public Book findBookByBookId(String bookId){ return bookRepository.findByBookId(bookId); }

    public List<Book> findAllBookByAuthor(Author author){ return bookRepository.findByAuthor(author); }

    public Book save(Book book) {
        if(book == null){
            throw new GraphQLErrorHandler("Data not found");
        }
        if(bookRepository.existsById(book.getBookId())){
            throw new GraphQLErrorHandler("book already exist");
        }
        validation.bookValidate(book);
        Book data = bookDataFormatting(book);
        return bookRepository.save(data);
    }

    public Book update(Book book){
        if(book == null){
            throw new GraphQLErrorHandler("Data not found");
        }
        if(!bookRepository.existsById(book.getBookId())){
            throw new GraphQLErrorHandler("book not exist");
        }
        Book data = merge(book);
        validation.bookValidate(book);
        return bookRepository.save(data);
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
        return bookDataFormatting(book);
    }

    public List<String> getListOfBookNameByAuthor(Author author){
        return findAllBookByAuthor(author).stream()
                .map(Book::getBookName)
                .collect(Collectors.toList());
    }

    private Book bookDataFormatting(Book book){
        book.setAuthor(authorDataFormatting(book.getAuthor()));
        book.setBookId(book.getBookId().toUpperCase());
        book.setBookName(book.getBookName().toUpperCase());
        return book;
    }
    // duplicate
    private Author authorDataFormatting(Author author){
        author.setAuthorId(author.getAuthorId().toUpperCase());
        author.setAuthorName(author.getAuthorName().toUpperCase());
        return author;
    }
}
