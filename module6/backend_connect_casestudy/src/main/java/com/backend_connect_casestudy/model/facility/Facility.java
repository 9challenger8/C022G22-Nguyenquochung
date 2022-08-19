package com.backend_connect_casestudy.model.facility;

import javax.persistence.*;

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

    private String otherConvenience;

    @Column(name = "pool_area")
    private String poolArea;

    @Column(name="number_of_floor")
    private String numberOfFloor;

    @Column(name = "facility_free")
    private String freeFacility;

    @ManyToOne
    @JoinColumn(name="rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name ="facility_type_id")
    private FacilityType facilityType;

    public Facility() {
    }

    public Facility(Integer id, String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String otherConvenience, String poolArea, String numberOfFloor, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Facility(Integer id, String name, String area, String cost, String numberOfPeople, String standardRoom,
                    String otherConvenience, String numberOfFloor, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.numberOfFloor = numberOfFloor;
        this.rentType = rentType;
        this.facilityType = facilityType;
    }

    public Facility(Integer id, String name, String area, String cost, String numberOfPeople,
                    String facilityFree, RentType rentType, FacilityType facilityType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.numberOfPeople = numberOfPeople;
        this.freeFacility = facilityFree;
        this.rentType = rentType;
        this.facilityType = facilityType;
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

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
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

    public String getFreeFacility() {
        return freeFacility;
    }

    public void setFreeFacility(String facilityFree) {
        this.freeFacility = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }
}
