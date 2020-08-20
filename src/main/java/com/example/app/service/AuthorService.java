package com.example.app.service;

import com.example.app.model.Author;
import com.example.app.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookService bookService;

    public List<Author> findAll(){ return authorRepository.findAll(); }

    public List<Author> findAuthorByAuthorName(String authorName){ return authorRepository.findAuthorByAuthorName(authorName); }

    public Author findAuthorByAuthorId(String authorId){
        return authorRepository.findById(authorId).orElse(null);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
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
}
