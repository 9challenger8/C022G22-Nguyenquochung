package case_study.controllers;

import case_study.common.CheckException;
import case_study.services.impl.CustomerManagement;
import case_study.services.impl.EmployeeManagement;
import case_study.services.impl.FacilityManagement;

import java.util.Scanner;

public class FuramaController {
    private static final Scanner scanner = new Scanner(System.in);
    EmployeeManagement employeeManagement = new EmployeeManagement();
    CustomerManagement customerManagement = new CustomerManagement();
    FacilityManagement facilityManagement = new FacilityManagement();


    public void displayMainMenu() {
        while (true) {
            System.out.println("☂☂☂☂☂☂☂☂CHÀO MỪNG BẠN ĐẾN ỨNG DỤNG QUẢN LÝ KHU NGHỈ DƯỠNG FURAMA☂☂☂☂☂☂☂☂ ");
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n ");
            System.out.print("Hãy chọn chức năng: ");
            int choice = CheckException.checkInteger();
            switch (choice) {
                case 1:
                    employeeManagement();
                    break;
                case 2:
                    customerManagement();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    System.out.println("1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    System.out.println("Hãy chọn chức năng: ");
                    int choice4 = CheckException.checkInteger();
                    switch (choice4) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            return;
                    }
                    break;
                case 5:
                    System.out.println("1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    int choice5 = CheckException.checkInteger();
                    switch (choice5) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn lại: ");
                    break;
            }
        }
    }

    private void facilityManagement() {
        System.out.println("1\tDisplay list facility\n" +
                "2\tAdd new facility\n" +
                "3\tDisplay list facility maintenance\n" +
                "4\tReturn main menu\n");
        System.out.println("Hãy chọn chức năng: ");
        int choice3 = CheckException.checkInteger();
        switch (choice3) {
            case 1:
                facilityManagement.displayList();
                break;
            case 2:
                addService();
                break;
            case 3:
                facilityManagement.displayListMaintenance();
                break;
            case 4:
        }
    }

    private void addService() {
        System.out.println("1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n");
        int choice32 = CheckException.checkInteger();
        switch (choice32) {
            case 1:
                facilityManagement.addNewVilla();
                break;
            case 2:
                facilityManagement.addNewHouse();
                break;
            case 3:
                facilityManagement.addNewRoom();
                break;
            case 4:
        }
    }

    private void customerManagement() {
        System.out.println("1.\tDisplay list customers\n" +
                "2.\tAdd new customer\n" +
                "3.\tEdit customer\n" +
                "4.\tReturn main menu\n");
        System.out.println("Hãy chọn chức năng: ");
        int choice2 = CheckException.checkInteger();
        switch (choice2) {
            case 1:
                customerManagement.displayList();
                break;
            case 2:
                customerManagement.addNew();
                break;
            case 3:
                customerManagement.edit();
                break;
            case 4:
        }
    }

    private void employeeManagement() {
        System.out.println("1\tDisplay list employees\n" +
                "2\tAdd new employee\n" +
                "3\tEdit employee\n" +
                "4\tReturn main menu\n");
        System.out.println("Hãy chọn chức năng: ");
        int choice1 = CheckException.checkInteger();
        switch (choice1) {
            case 1:
                employeeManagement.displayList();
                break;
            case 2:
                employeeManagement.addNew();
                break;
            case 3:
                employeeManagement.edit();
                break;
            case 4:
                break;
            default:
                System.out.print("Hãy chọn lại: ");
                choice1 = CheckException.checkInteger();
                break;
        }
    }
}
