package com.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String detail;

    @Column(name = "date_create")
    private String dateCreate;

    public Blog() {
    }

    public Blog(Integer id, String name, String detail, String dateCreate) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.dateCreate = dateCreate;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
}
