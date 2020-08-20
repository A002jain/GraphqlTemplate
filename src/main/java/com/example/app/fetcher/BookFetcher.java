package com.example.app.fetcher;

import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Component
public class BookFetcher {

    @Resource
    BookService bookService;

    public DataFetcher<List<Book>> findAll() {
        return dataFetchingEnvironment -> bookService.findAll();
    }

    public DataFetcher<Book> findBookByName() {
        return dataFetchingEnvironment -> {
            String bookName = dataFetchingEnvironment.getArgument("bookName");
            return bookService.findBookByName(bookName);
        };
    }

    public DataFetcher<Book> findBookByBookId() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("bookId");
            return bookService.findBookByBookId(bookId);
        };
    }

    public DataFetcher<List<Book>> findAllBookByAuthor() {
        return dataFetchingEnvironment -> {
            Author author = dataFetchingEnvironment.getSource();
            return bookService.findAllBookByAuthor(author);
        };
    }

    public DataFetcher<Book> save() {
        return dataFetchingEnvironment -> {
            ObjectMapper mapper = new ObjectMapper();
            Book book =mapper.convertValue(dataFetchingEnvironment.getArgument("book"),Book.class);
            return bookService.save(book);
        };
    }
}
