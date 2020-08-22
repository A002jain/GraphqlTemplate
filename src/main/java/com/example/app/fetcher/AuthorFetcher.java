package com.example.app.fetcher;

import com.example.app.interfaces.AuthorService;
import com.example.app.model.Author;
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

    public DataFetcher<List<Author>> findAuthorByAuthorName() {
        return  dataFetchingEnvironment -> {
        String authorName = dataFetchingEnvironment.getArgument("authorName");
        return authorService.findAuthorByAuthorName(authorName);
        };
    }

    public DataFetcher<Author> findAuthorByAuthorId() {
        return  dataFetchingEnvironment -> {
            String authorId = dataFetchingEnvironment.getArgument("authorId");
            return authorService.findAuthorByAuthorId(authorId);
        };
    }

    public DataFetcher<Author> save() {
        return dataFetchingEnvironment -> {
            ObjectMapper mapper = new ObjectMapper();
            Author author =mapper.convertValue(dataFetchingEnvironment.getArgument("author"),Author.class);
            return authorService.save(author);
        };
    }

    public DataFetcher<Author> update() {
        return dataFetchingEnvironment -> {
            ObjectMapper mapper = new ObjectMapper();
            Author author =mapper.convertValue(dataFetchingEnvironment.getArgument("author"),Author.class);
            return authorService.update(author);
        };
    }

}
