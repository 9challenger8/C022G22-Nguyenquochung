package case_study.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private Double swimmingPoolArea;
    private Integer numberOfFloor;

    public Villa() {
    }



    public Villa(String codeService, String serviceName, Double usableArea, Double rentalCosts, Integer amountOfPeople, String rentalType, String roomStandard, Double swimmingPoolArea, Integer numberOfFloor) {
        super(codeService, serviceName, usableArea, rentalCosts, amountOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(Double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }


    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", swimmingPoolArea=" + swimmingPoolArea +
                ", numberOfFloor=" + numberOfFloor +
                "} " + super.toString();
    }
}
