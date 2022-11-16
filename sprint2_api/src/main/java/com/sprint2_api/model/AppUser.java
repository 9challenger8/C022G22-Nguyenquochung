package com.sprint2_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<UserRole> userRoleList;

    @OneToOne(mappedBy = "appUser")
    @JsonBackReference
    private Customer customer;

    public AppUser() {
    }

    public AppUser(Integer id, String username, String password, String email, Boolean isDeleted,
                   List<UserRole> userRoleList, Customer customer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isDeleted = isDeleted;
        this.userRoleList = userRoleList;
        this.customer = customer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}