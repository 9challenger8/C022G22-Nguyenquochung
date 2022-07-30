package com.connect_spring_vs_exam_module5.model;

import javax.persistence.*;

@Entity
@Table(name = "series_product")
public class SeriesProduct {

    @Id
    private String id;

    private String amount;

    @Column(name = "start_date")
    private String startDate;

    @Column(name= "produce_date")
    private String produceDate;

    @Column(name="expiration_date")
    private String expirationDate;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


    public SeriesProduct() {
    }

    public SeriesProduct(String id, String amount, String startDate, String produceDate, String expirationDate, Product product) {
        this.id = id;
        this.amount = amount;
        this.startDate = startDate;
        this.produceDate = produceDate;
        this.expirationDate = expirationDate;
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
