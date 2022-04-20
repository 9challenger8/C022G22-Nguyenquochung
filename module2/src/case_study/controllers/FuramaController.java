package case_study.controllers;

import java.util.Scanner;

public class FuramaController {
        private static Scanner scanner = new Scanner(System.in);


        public void displayMainMenu(){
                while (true) {
                        System.out.println("Chào mừng bạn đến ứng dụng quản lý khu  nghỉ dưỡng Furama ");
                        System.out.println("1.\tEmployee Management\n" +
                                "2.\tCustomer Management\n" +
                                "3.\tFacility Management \n" +
                                "4.\tBooking Management\n" +
                                "5.\tPromotion Management\n" +
                                "6.\tExit\n ");
                        System.out.println("Hãy chọn chức năng: ");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                                case 1:
                                        System.out.println("1\tDisplay list employees\n" +
                                                "2\tAdd new employee\n" +
                                                "3\tEdit employee\n" +
                                                "4\tReturn main menu\n");
                                        System.out.println("Hãy chọn chức năng: ");
                                        int choice1 = Integer.parseInt(scanner.nextLine());
                                        switch (choice1) {
                                                case 1:
                                                        break;
                                                case 2:
                                                        break;
                                                case 3:
                                                        break;
                                                case 4:
                                                        break;
                                        }
                                        break;
                                case 2:
                                        System.out.println("1.\tDisplay list customers\n" +
                                                "2.\tAdd new customer\n" +
                                                "3.\tEdit customer\n" +
                                                "4.\tReturn main menu\n");
                                        System.out.println("Hãy chọn chức năng: ");
                                        int choice2 = Integer.parseInt(scanner.nextLine());
                                        switch (choice2) {
                                                case 1:
                                                        break;
                                                case 2:
                                                        break;
                                                case 3:
                                                        break;
                                                case 4:
                                                        break;
                                        }
                                        break;
                                case 3:
                                        System.out.println("1\tDisplay list facility\n" +
                                                "2\tAdd new facility\n" +
                                                "3\tDisplay list facility maintenance\n" +
                                                "4\tReturn main menu\n");
                                        System.out.println("Hãy chọn chức năng: ");
                                        int choice3 = Integer.parseInt(scanner.nextLine());
                                        switch (choice3) {
                                                case 1:
                                                        break;
                                                case 2:
                                                        break;
                                                case 3:
                                                        break;
                                                case 4:
                                                        break;
                                        }
                                        break;
                                case 4:
                                        System.out.println("1.\tAdd new booking\n" +
                                                "2.\tDisplay list booking\n" +
                                                "3.\tCreate new constracts\n" +
                                                "4.\tDisplay list contracts\n" +
                                                "5.\tEdit contracts\n" +
                                                "6.\tReturn main menu\n");
                                        System.out.println("Hãy chọn chức năng: ");
                                        int choice4 = Integer.parseInt(scanner.nextLine());
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
                                                        break;
                                        }
                                        break;
                                case 5:
                                        System.out.println("1.\tDisplay list customers use service\n" +
                                                "2.\tDisplay list customers get voucher\n" +
                                                "3.\tReturn main menu\n");
                                        int choice5 = Integer.parseInt(scanner.nextLine());
                                        switch (choice5) {
                                                case 1:
                                                        break;
                                                case 2:
                                                        break;
                                                case 3:
                                                        break;
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
}
