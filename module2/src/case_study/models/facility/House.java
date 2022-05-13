package case_study.models.facility;

public class House extends Facility {
    private String roomStandard;
    private Integer numberOfFloor;

    public House() {
    }


    public House(String codeService, String serviceName, Double usableArea, Integer rentalCosts, Integer amountOfPeople, String rentalType, String roomStandard, Integer numberOfFloor) {
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
    public String getInFor() {
        return super.getInFor()+", "+this.roomStandard+", "+this.numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString()+", "+this.roomStandard+", "+this.numberOfFloor;
    }
}
