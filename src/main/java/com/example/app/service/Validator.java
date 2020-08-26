package com.example.app.service;

import com.example.app.exception.GraphQLErrorHandler;
import com.example.app.model.Author;
import com.example.app.model.Book;
import org.springframework.stereotype.Service;

@Service
public class Validator implements com.example.app.interfaces.Validation {


    public void bookValidate(Book book) {

        if (book.getBookId() == null || book.getBookId().isEmpty()) {
            throw new GraphQLErrorHandler("bookId is manadatory");
        }
        if (book.getBookName() == null || book.getBookName().isEmpty()) {
            throw new GraphQLErrorHandler("bookName is manadatory");
        }
        if(book.getPages() == 0){
            throw new GraphQLErrorHandler("book cannot have 0 pages");
        }
        if(book.getPrice() == 0.0d){
            throw new GraphQLErrorHandler("enter price of book");
        }
        if (book.getRating() > 10.0d) {
            throw new GraphQLErrorHandler("rating should be between 0-10");
        }
        authorValidate(book.getAuthor());
    }

    public void authorValidate(Author author){
        if (author == null) {
            throw new GraphQLErrorHandler("enter book`s author details or publication");
        } else {
            if (author.getAuthorName() == null || author.getAuthorName().isEmpty()
                    || author.getAuthorId() == null || author.getAuthorId().isEmpty()) {
                throw new GraphQLErrorHandler("enter author details or publication");
            }
        }
    }
}
