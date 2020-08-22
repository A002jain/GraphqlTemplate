package com.example.app.config.stepdefs;

import com.example.app.interfaces.BookService;
import com.example.app.model.Author;
import com.example.app.model.Book;
import com.example.app.repository.BookRepository;
import com.example.app.service.IBookService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.Mockito;

import java.util.List;

public class MyStepdefs {

    private IBookService bookService;
    private BookRepository bookRepository;
    private String id;
    private String bookName;
    private Author author;
    @Before
    public void createInstance() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService= new IBookService(bookRepository);
        id="b1";
        bookName="harry Potter";
        author = new Author();
        author.setAuthorId("a2");
        author.setAuthorName("JKR");
    }

    @When("calling findAll book by Author")
    public void callingFindAllBookByAuthor() {
        Mockito.when(bookService.findAllBookByAuthor(Mockito.any())).thenReturn(Mockito.anyList());
        bookService.findAllBookByAuthor(author);
    }

    @Then("check findAllBookByAuthor called")
    public void checkFindAllBookByAuthorCalled() {
        Mockito.verify(bookRepository).findByAuthor(Mockito.eq(author));
    }

    @When("calling find by name")
    public void callingFindByName() {
        Mockito.when(bookService.findBookByName(Mockito.anyString())).thenReturn(Mockito.any());
        bookService.findBookByName(bookName);
    }

    @Then("check findBookName called")
    public void checkFindBookNameCalled() {
        Mockito.verify(bookRepository).findByBookName(Mockito.contains(bookName));
    }

    @When("calling find by id")
    public void callingFindById() {
        Mockito.when(bookService.findBookByBookId(Mockito.anyString())).thenReturn(Mockito.any());
        bookService.findBookByBookId(id);
    }

    @Then("check findBookId called")
    public void checkFindBookIdCalled() {
        Mockito.verify(bookRepository).findByBookId(Mockito.contains(id));
    }
}
