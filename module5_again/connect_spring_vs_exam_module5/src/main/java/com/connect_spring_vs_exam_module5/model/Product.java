package com.connect_spring_vs_exam_module5.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String producer;

    private String cost;

    private String unit;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<SeriesProduct> seriesProductList;

    public Product() {
    }

    public Product(Integer id, String name, String producer, String cost, String unit, List<SeriesProduct> seriesProductList) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.cost = cost;
        this.unit = unit;
        this.seriesProductList = seriesProductList;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<SeriesProduct> getSeriesProductList() {
        return seriesProductList;
    }

    public void setSeriesProductList(List<SeriesProduct> seriesProductList) {
        this.seriesProductList = seriesProductList;
    }
}
