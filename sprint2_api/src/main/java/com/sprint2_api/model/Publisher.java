package com.sprint2_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namePublisher;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> bookList;

    public Publisher() {
    }

    public Publisher(Integer id, String namePublisher, List<Book> bookList) {
        this.id = id;
        this.namePublisher = namePublisher;
        this.bookList = bookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String name) {
        this.namePublisher = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
