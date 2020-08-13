package com.example.app.fetcher;

import com.example.app.model.Book;
import com.example.app.service.BookService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.List;

@Component
public class BookFetcher {

    @Resource
    BookService bookService;
    public DataFetcher<List<Book>> findAll() {
        return new DataFetcher<List<Book>>() {
            public List<Book> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
                return bookService.findAll();
            }
        };
    }
}
