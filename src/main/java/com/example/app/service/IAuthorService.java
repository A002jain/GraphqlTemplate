package com.example.app.service;

import com.example.app.exception.GraphQLErrorHandler;
import com.example.app.interfaces.AuthorService;
import com.example.app.interfaces.Validation;
import com.example.app.model.Author;
import com.example.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAuthorService implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    Validation validation;
    public List<Author> findAll(){ return authorRepository.findAll(); }

    public List<Author> findAuthorByAuthorName(String authorName){ return authorRepository.findAuthorByAuthorName(authorName.toUpperCase()); }

    public Author findAuthorByAuthorId(String authorId){
        return authorRepository.findById(authorId).orElse(null);
    }

    public Author save(Author author) {
        if(authorRepository.existsById(author.getAuthorId()))
            throw new GraphQLErrorHandler("Already exist");
        validation.authorValidate(author);
        Author authorData = dataFormatting(author);
        return authorRepository.save(authorData);
    }

    public Author update(Author author) {
        return authorRepository.save(merge(author));
    }

    private Author merge(Author author){
        Author orgAuthor = findAuthorByAuthorId(author.getAuthorId());
        if (author.getAuthorName()==null || author.getAuthorName().isEmpty()){
            author.setAuthorName(orgAuthor.getAuthorName());
        }
        return author;
    }

    private Author dataFormatting(Author author){
        author.setAuthorId(author.getAuthorId().toUpperCase());
        author.setAuthorName(author.getAuthorName().toUpperCase());
        return author;
    }
}
