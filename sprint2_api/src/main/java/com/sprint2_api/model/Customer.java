package com.sprint2_api.model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String birthday;

    private String address;

    private String email;

    private String gender;

    private String name;

    private String phone;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    public Customer() {
    }

    public Customer(Integer id, String birthday, String address, String email, String gender, String name, String phone,
                    Boolean isDeleted, AppUser appUser, Cart cart) {
        this.id = id;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.phone = phone;
        this.isDeleted = isDeleted;
        this.appUser = appUser;
        this.cart = cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
