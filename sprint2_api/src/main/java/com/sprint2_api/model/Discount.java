package com.sprint2_api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String percent;

    @OneToMany(mappedBy = "discount")
    private List<Book> bookList;

    public Discount() {
    }

    public Discount(Integer id, String percent, List<Book> bookList) {
        this.id = id;
        this.percent = percent;
        this.bookList = bookList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
