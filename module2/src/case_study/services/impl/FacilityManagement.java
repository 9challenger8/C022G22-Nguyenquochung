package case_study.services.impl;

import case_study.common.ReadAndWriteFile;
import case_study.common.Regex;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.services.IFacilityServices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityManagement implements IFacilityServices {
    static Map<Facility, Integer> listFacilityManagement = new LinkedHashMap<>();
    static Map<Villa, Integer> listVilla = new LinkedHashMap<>();
    static Map<Room, Integer> listRoom = new LinkedHashMap<>();
    static Map<House, Integer> listHouse = new LinkedHashMap<>();
    static List<Facility> listFacilityMaintain= new ArrayList<>();

    @Override
    public void displayList() {
        listRoom = ReadAndWriteFile.readRoom();
        listHouse = ReadAndWriteFile.readHouse();
        listVilla = ReadAndWriteFile.readVilla();
        listFacilityManagement.putAll(listRoom);
        listFacilityManagement.putAll(listHouse);
        listFacilityManagement.putAll(listVilla);
        for (Map.Entry<Facility, Integer> facility : listFacilityManagement.entrySet()) {
            System.out.println(facility.getKey()+ ", Số lần sử dụng: " + facility.getValue());
        }
    }

    @Override
    public void addNewHouse() {
        listHouse=ReadAndWriteFile.readHouse();
        String codeService = Regex.inputHouseCodeService();
        String serviceName = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Integer rentalCost = Integer.parseInt(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String roomStandard = Regex.inputRoomStandard();
        Integer numberOfFloor = Integer.parseInt(Regex.inputNumberOfFloor());
        listHouse.put(new House(codeService, serviceName, usableArea, rentalCost, amountOfPeople, rentalType, roomStandard, numberOfFloor), 4);
        ReadAndWriteFile.writeHouse(listHouse);
    }

    @Override
    public void addNewRoom() {
        listRoom=ReadAndWriteFile.readRoom();
        String codeService = Regex.inputRoomCodeService();
        String serviceNam = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Integer rentalCost = Integer.parseInt(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String freeService = Regex.inputFreeService();
        listRoom.put(new Room(codeService, serviceNam, usableArea, rentalCost, amountOfPeople, rentalType, freeService), 4);
        ReadAndWriteFile.writeRoom(listRoom);
    }

    @Override
    public void addNewVilla() {
        listVilla=ReadAndWriteFile.readVilla();
        String codeService = Regex.inputVillaCodeService();
        String serviceName = Regex.inputServiceName();
        Double usableArea = Double.parseDouble(Regex.inputUsableArea());
        Integer rentalCost = Integer.parseInt(Regex.inputRentalCost());
        Integer amountOfPeople = Integer.parseInt(Regex.inputAmountOfPeople());
        String rentalType = Regex.inputRentalType();
        String roomStandard = Regex.inputRoomStandard();
        Double swimmingPoolArea = Double.valueOf(Regex.inputSwimmingPoolArea());
        Integer numberOfFloor = Integer.parseInt(Regex.inputNumberOfFloor());
        listVilla.put(new Villa(codeService, serviceName, usableArea, rentalCost, amountOfPeople, rentalType, roomStandard, swimmingPoolArea, numberOfFloor), 5);
        ReadAndWriteFile.writeVilla(listVilla);
    }

    @Override
    public void displayListMaintenance() {
        listRoom = ReadAndWriteFile.readRoom();
        listHouse = ReadAndWriteFile.readHouse();
        listVilla = ReadAndWriteFile.readVilla();
        listFacilityManagement.putAll(listRoom);
        listFacilityManagement.putAll(listHouse);
        listFacilityManagement.putAll(listVilla);
        for (Map.Entry<Facility, Integer> facility : listFacilityManagement.entrySet()) {
            if (facility.getValue() >= 5) {
                System.out.println(facility.getKey() + ",Số lần sử dụng: " + facility.getValue());
            }
        }
    }
}
