package com.sprint2_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private String name;

    private String price;

    private String author;

    private String quantity;

    private String releaseDate;

    private String image;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BookOrder> bookOrderList;

    public Book() {
    }

    public Book(Integer id, String description, String name, String price, String author, String quantity,
                String releaseDate, Boolean isDeleted, Publisher publisher, Category category, Discount discount, List<BookOrder> bookOrderList) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        this.author = author;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.isDeleted = isDeleted;
        this.publisher = publisher;
        this.category = category;
        this.discount = discount;
        this.bookOrderList = bookOrderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public List<BookOrder> getCartDetailList() {
        return bookOrderList;
    }

    public void setCartDetailList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<BookOrder> getBillDetailList() {
        return bookOrderList;
    }

    public void setBillDetailList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }
}
