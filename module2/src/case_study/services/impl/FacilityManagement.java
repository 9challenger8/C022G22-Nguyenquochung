package case_study.services.impl;

import case_study.common.Regex;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.services.IFacilityServices;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityManagement implements IFacilityServices {

    Scanner scanner = new Scanner(System.in);
    static Map<Facility, Integer> listFacilityManagement = new LinkedHashMap<>();

    static {
        listFacilityManagement.put(new Room("SVHO-1234", "Room", 30.5, 500.5, 4, "Day", "Buffet"), 4);
        listFacilityManagement.put(new House("SVHO-1234", "House", 100.0, 1200.0, 8, "Month", "Normal", 2), 5);
        listFacilityManagement.put(new Villa("SVVL-1234", "Villa", 170.0, 2000.0, 15, "Week", "Vip", 30.9, 4), 5);
        listFacilityManagement.put(new Room("SVHO-4321", "Room", 30.5, 500.5, 4, "Month", "Buffet"), 2);

    }

    @Override
    public void displayList() {
        for (Map.Entry<Facility, Integer> facility : listFacilityManagement.entrySet()) {
            System.out.println(facility.getKey() + " , số lần sử : " + facility.getValue());
        }
    }

    @Override
    public void addNewHouse() {
        String codeService = Regex.inputHouseCodeService();
        String serviceName = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Double rentalCost = Double.parseDouble(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String roomStandard = Regex.inputRoomStandard();
        Integer numberOfFloor = Integer.parseInt(Regex.inputNumberOfFloor());
        listFacilityManagement.put(new House(codeService, serviceName, usableArea, rentalCost, amountOfPeople, rentalType, roomStandard, numberOfFloor), 4);
    }

    @Override
    public void addNewRoom() {
        String codeService = Regex.inputRoomCodeService();
        String serviceName = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Double rentalCost = Double.parseDouble(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String freeService = Regex.inputFreeService();
        listFacilityManagement.put(new Room(codeService, serviceName, usableArea, rentalCost, amountOfPeople, rentalType, freeService), 4);
    }

    @Override
    public void addNewVilla() {
        String codeService = Regex.inputVillaCodeService();
        String serviceName = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Double rentalCost = Double.valueOf(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String roomStandard = Regex.inputRoomStandard();
        Double swimmingPoolArea = Double.valueOf(Regex.inputSwimmingPoolArea());
        Integer numberOfFloor = Integer.parseInt(Regex.inputNumberOfFloor());
        listFacilityManagement.put(new Villa(codeService, serviceName, usableArea, rentalCost, amountOfPeople, rentalType, roomStandard, swimmingPoolArea, numberOfFloor), 5);
    }

    @Override
    public void displayListMaintenance() {
        for (Map.Entry<Facility, Integer> facility : listFacilityManagement.entrySet()) {
            if (facility.getValue() >= 5) {
                System.out.println(facility.getKey() + " , số lần sử dụng: " + facility.getValue());
            }
        }
    }
}
