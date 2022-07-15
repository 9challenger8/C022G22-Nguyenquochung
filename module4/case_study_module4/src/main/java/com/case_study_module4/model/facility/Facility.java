package com.case_study_module4.model.facility;

import com.case_study_module4.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String area;
    private String cost;

    @Column(name = "max_people")
    private String numberOfPeople;

    @Column(name = "standard_room")
    private String standardRoom;

    private String description;

    @Column(name = "pool_area")
    private String poolArea;

    @Column(name="number_of_floor")
    private String numberOfFloor;

    @Column(name = "facility_free")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name="facility_type_id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name="rent_type_id")
    private RentType rentType;

    @OneToMany(mappedBy = "facility")
    @JsonBackReference
    private List<Contract> contractList;




    public Facility() {
    }

    public Facility(Integer id, String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String description, String poolArea, String numberOfFloor, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String description, String poolArea, String numberOfFloor, FacilityType facilityType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String description, String numberOfFloor, FacilityType facilityType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.numberOfFloor = numberOfFloor;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(String name, String area, String cost, String numberOfPeople, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Facility(Integer id, String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String description, String poolArea, String numberOfFloor, String facilityFree, FacilityType facilityType, RentType rentType, List<Contract> contractList) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
        this.contractList = contractList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
