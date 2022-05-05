package case_study.models.facility;

import case_study.models.facility.Facility;

import java.util.Date;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloor;

    public House() {
    }

    public House(String codeService, String serviceName, Double usableArea, Double rentalCosts, Integer amountOfPeople, String rentalType, String roomStandard, Integer numberOfFloor) {
        super(codeService, serviceName, usableArea, rentalCosts, amountOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
