package com.sprint2_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "app_role_id")
    private AppRole appRole;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    public UserRole() {
    }

    public UserRole(Integer id, AppRole appRole, AppUser appUser) {
        this.id = id;
        this.appRole = appRole;
        this.appUser = appUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
