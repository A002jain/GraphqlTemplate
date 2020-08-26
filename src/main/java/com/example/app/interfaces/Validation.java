package com.example.app.interfaces;

import com.example.app.model.Author;
import com.example.app.model.Book;

public interface Validation {

    void bookValidate(Book book);

    void authorValidate(Author author);
}
