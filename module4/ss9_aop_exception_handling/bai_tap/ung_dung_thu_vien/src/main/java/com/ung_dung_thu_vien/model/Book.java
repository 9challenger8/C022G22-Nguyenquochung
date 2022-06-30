package com.ung_dung_thu_vien.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;
    private String image;
    private String name;

    @OneToMany(mappedBy = "book")
    private List<BookDetail> listBookDetail;



    public Book() {
    }

    public Book(Integer id, String name, Integer amount, String image) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BookDetail> getListBookDetail() {
        return listBookDetail;
    }

    public void setListBookDetail(List<BookDetail> listBookDetail) {
        this.listBookDetail = listBookDetail;
    }
}
