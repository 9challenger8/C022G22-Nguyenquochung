package com.exam_module4.model;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    private String id;

    private String area;

    private String cost;

    private String status;

    @OneToOne(mappedBy = "room")
    private Contract contract;

    public Room() {
    }

    public Room(String id, String area, String cost, String status, Contract contract) {
        this.id = id;
        this.area = area;
        this.cost = cost;
        this.status = status;
        this.contract = contract;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
