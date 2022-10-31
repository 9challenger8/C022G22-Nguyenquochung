package com.sprint2_api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bill {

    @Id
    private String id;

    @Column(name = "date_create")
    private String dateCreate;

    @Column(name = "is_deleted",columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private List<BookOrder> bookOrderList;

    @OneToMany(mappedBy = "bill")
    @JsonIgnore
    private List<BillDetail> billDetailList;

    public Bill() {
    }

    public Bill(String id, String dateCreate, Boolean isDeleted, List<BookOrder> bookOrderList, List<BillDetail> billDetailList) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.isDeleted = isDeleted;
        this.bookOrderList = bookOrderList;
        this.billDetailList = billDetailList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    public List<BillDetail> getBillDetailList() {
        return billDetailList;
    }

    public void setBillDetailList(List<BillDetail> billDetailList) {
        this.billDetailList = billDetailList;
    }
}
