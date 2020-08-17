package com.example.app.fetcher;

import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class AuthorFetcher {

    @Resource
    AuthorService authorService;
    public DataFetcher<List<Author>> findAll() {
        return  dataFetchingEnvironment -> authorService.findAll();
    }
    public  DataFetcher<Author> findAllAuthorForBook(){
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return authorService.findAllAuthorForBook(book);
        };
    }

    public DataFetcher<Author> save() {
        return dataFetchingEnvironment -> {
            ObjectMapper mapper = new ObjectMapper();
            Author author =mapper.convertValue(dataFetchingEnvironment.getArguments(),Author.class);
            return authorService.save(author);
        };
    }
}
