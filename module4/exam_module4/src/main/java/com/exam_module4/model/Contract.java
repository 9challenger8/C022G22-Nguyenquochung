package com.exam_module4.model;

import javax.persistence.*;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    private String id;

    @Column(name = "name_rent")
    private String nameRent;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "time_rent")
    private String timeRent;

    @Column(name = "total_money")
    private String totalMoney;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Contract() {
    }

    public Contract(String id, String nameRent, String idCard, String startDate, String timeRent, String totalMoney, Room room) {
        this.id = id;
        this.nameRent = nameRent;
        this.idCard = idCard;
        this.startDate = startDate;
        this.timeRent = timeRent;
        this.totalMoney = totalMoney;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameRent() {
        return nameRent;
    }

    public void setNameRent(String nameRent) {
        this.nameRent = nameRent;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String timeRent) {
        this.timeRent = timeRent;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
