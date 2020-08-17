package com.example.app.fetcher;

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

    public DataFetcher<Book> save() {
        return dataFetchingEnvironment -> {
            ObjectMapper mapper = new ObjectMapper();
            Book book =mapper.convertValue(dataFetchingEnvironment.getArguments(),Book.class);
            return bookService.save(book);
        };
    }
}
