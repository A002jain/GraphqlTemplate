package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @JsonProperty("bookId")
    @Id
    @Column(name = "bookId")
    private String bookId;

    @JsonProperty("bookName")
    @Column(name = "bookName")
    private String  bookName;

    @JsonProperty("pages")
    @Column(name = "pages")
    private int pages;

    @JsonProperty("price")
    @Column(name = "price")
    private double price;

    @JsonProperty("rating")
    @Column(name = "rating")
    private double rating;

    @JsonProperty("author")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Author author;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public double getRating() { return rating; }

    public void setRating(double rating) { this.rating = rating; }

}
