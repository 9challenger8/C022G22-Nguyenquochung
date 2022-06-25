package com.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProductDto {


    private Integer id;

    @NotEmpty
    @Size(max=50,message = "Length is max 50")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "khong chua ki tu dac biet")
    private String name;

    @NotEmpty
    @Size(max=50,message = "Length is max 50")
    @Pattern(regexp = "^[0-9]*$",message = "number")
    private String  price;

    @NotEmpty
    @Size(max=50,message = "Length is max 50")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "khong chua ki tu dac biet")
    private String detail;

    @NotEmpty
    @Size(max=50,message = "Length is max 50")
    @Pattern(regexp = "^[a-zA-Z0-9]*$",message = "khong chua ki tu dac biet")
    private String producer;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String price, String detail, String producer) {
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
