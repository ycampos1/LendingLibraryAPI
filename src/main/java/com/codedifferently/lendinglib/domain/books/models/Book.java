package com.codedifferently.lendinglib.domain.books.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private LocalDate publishDate;

    private Boolean inLibrary;

    public Book() {
    }

    public Book(String title, LocalDate publishDate) {
        this.title = title;
        this.publishDate = publishDate;
        this.inLibrary = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Boolean getInLibrary() {
        return inLibrary;
    }

    public void setInLibrary(Boolean checkedOut) {
        this.inLibrary = checkedOut;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishDate=" + publishDate +
                ", checkedOut=" + inLibrary +
                '}';
    }
}
