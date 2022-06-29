package com.ung_dung_thu_vien.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book_detail")
public class BookDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBookDetail;

    @Column(name = "id_book")
    private Integer idBook;
    private String name;
    private String author;

    @OneToMany(mappedBy = "bookDetail")
    private List<Book> listBook;

    public BookDetail() {
    }

    public BookDetail(Integer idBookDetail, Integer idBook, String name, String author, List<Book> listBook) {
        this.idBookDetail = idBookDetail;
        this.idBook = idBook;
        this.name = name;
        this.author = author;
        this.listBook = listBook;
    }

    public Integer getIdBookDetail() {
        return idBookDetail;
    }

    public void setIdBookDetail(Integer idBookDetail) {
        this.idBookDetail = idBookDetail;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }
}
