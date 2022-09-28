package com.final_exam_codegym_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_manager")
    private String nameManager;

    @Column(name = "code_manager")
    private String codeManager;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String gender;

    @JsonIgnore
    @OneToOne(mappedBy = "manager")
    private Facility facility;

    public Manager() {
    }

    public Manager(Integer id, String nameManager, String codeManager, String dateOfBirth, String gender, Facility facility) {
        this.id = id;
        this.nameManager = nameManager;
        this.codeManager = codeManager;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.facility = facility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getCodeManager() {
        return codeManager;
    }

    public void setCodeManager(String codeManager) {
        this.codeManager = codeManager;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
