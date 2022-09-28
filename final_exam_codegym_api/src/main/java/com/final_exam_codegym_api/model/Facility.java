package com.final_exam_codegym_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code_facility")
    private String codeFacility;

    @Column(name = "name_facility")
    private String nameFacility;

    @Column(name="open_day")
    private String openDay;

    private String address;

    @Column(columnDefinition = "BIT(1) DEFAULT 0",name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "facility")
    private List<Customer> customerList;

    @OneToMany(mappedBy = "facility")
    private List<PT> ptList;

    @OneToOne()
    @JoinColumn(name = "manager_id")
    private Manager manager;

    public Facility() {
    }

    public Facility(Integer id, String codeFacility, String nameFacility, String openDay, String address,
                    Boolean isDeleted, Manager manager) {
        this.id = id;
        this.codeFacility = codeFacility;
        this.nameFacility = nameFacility;
        this.openDay = openDay;
        this.address = address;
        this.isDeleted = isDeleted;
        this.manager = manager;
    }

    public Facility(Integer id, String nameFacility, String openDay, String address, List<Customer> customerList,
                    List<PT> ptList, Manager manager) {
        this.id = id;
        this.nameFacility = nameFacility;
        this.openDay = openDay;
        this.address = address;
        this.customerList = customerList;
        this.ptList = ptList;
        this.manager = manager;
    }

    public String getCodeFacility() {
        return codeFacility;
    }

    public void setCodeFacility(String codeFacility) {
        this.codeFacility = codeFacility;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getOpenDay() {
        return openDay;
    }

    public void setOpenDay(String openDay) {
        this.openDay = openDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<PT> getPtList() {
        return ptList;
    }

    public void setPtList(List<PT> ptList) {
        this.ptList = ptList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
