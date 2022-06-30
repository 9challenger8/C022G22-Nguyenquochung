package com.ung_dung_thu_vien.model;

import javax.persistence.*;

@Entity
@Table(name = "book_detail")
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_borrow")
    private Integer idBorrow;
    private String author;
    private String year;

    @Column(columnDefinition = "integer default 0")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "id_book",referencedColumnName ="id" )
    private Book book;


    public BookDetail() {
    }

    public BookDetail(Integer idBorrow, String author, String year, Integer status, Book book) {
        this.idBorrow = idBorrow;
        this.author = author;
        this.year = year;
        this.status = status;
        this.book = book;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
