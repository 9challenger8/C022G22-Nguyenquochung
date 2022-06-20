package com.model;

public class Product {
    private Integer id;
    private String name;
    private String  price;
    private String detail;
    private String producer;

    public Product() {
    }

    public Product(Integer id, String name, String price, String detail, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.producer = producer;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
