package case_study.models.facility;

import java.util.Date;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String codeService, String serviceName, Double usableArea, Integer rentalCosts, Integer amountOfPeople, String rentalType, String freeService) {
        super(codeService, serviceName, usableArea, rentalCosts, amountOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getInFor() {
        return super.getInFor()+", "+this.freeService;
    }

    @Override
    public String toString() {
        return super.toString()+", "+this.freeService;
    }
}
