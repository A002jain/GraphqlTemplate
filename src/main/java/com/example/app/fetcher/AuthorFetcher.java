package com.example.app.fetcher;

import com.example.app.model.Author;
import com.example.app.service.AuthorService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AuthorFetcher {

    @Resource
    AuthorService authorService;
    public DataFetcher<List<Author>> findAll() {
        return new DataFetcher<List<Author>>() {
            public List<Author> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
                return authorService.findAll();
            }
        };
    }
}
