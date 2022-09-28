package com.final_exam_codegym_api.model;

import javax.persistence.*;

@Entity
@Table(name = "pt")
public class PT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_pt")
    private String namePT;

    @Column(name = "code_pt")
    private String codePT;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    private String gender;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    public PT() {
    }

    public PT(Integer id, String namePT, String codePT, String dateOfBirth, String gender, Facility facility) {
        this.id = id;
        this.namePT = namePT;
        this.codePT = codePT;
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

    public String getNamePT() {
        return namePT;
    }

    public void setNamePT(String namePT) {
        this.namePT = namePT;
    }

    public String getCodePT() {
        return codePT;
    }

    public void setCodePT(String codePT) {
        this.codePT = codePT;
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
