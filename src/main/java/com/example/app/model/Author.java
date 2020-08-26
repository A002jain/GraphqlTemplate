package com.example.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @JsonProperty("authorId")
    @Column(name = "authorId")
    @Id
    private String authorId;

    @JsonProperty("authorName")
    @Column(name = "authorName")
    private String authorName;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
