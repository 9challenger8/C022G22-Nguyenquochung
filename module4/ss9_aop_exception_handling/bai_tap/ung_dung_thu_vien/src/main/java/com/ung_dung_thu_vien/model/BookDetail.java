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

    private String author;

    private String content;

    @OneToMany(mappedBy = "bookDetail")
    private List<Book> listBook;

    public BookDetail() {
    }

    public BookDetail(Integer idBookDetail, Integer idBook, String author, String content) {
        this.idBookDetail = idBookDetail;
        this.idBook = idBook;
        this.author = author;
        this.content = content;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Book> getListBook() {
        return listBook;
    }

    public void setListBook(List<Book> listBook) {
        this.listBook = listBook;
    }
}
