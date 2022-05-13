package thi_ket_thuc_module2.controllers;


import thi_ket_thuc_module2.common.CheckException;
import thi_ket_thuc_module2.services.impl.MobileServices;

public class MobileController {
    MobileServices mobileServices = new MobileServices();

    public void displayMainMenu() {
        while (true) {
            System.out.println("CHUONG TRINH QUAN LY DIEN THOAI ");
            System.out.println("1.\tAdd New\n" +
                    "2.\tDelete\n" +
                    "3.\tDisplay List Mobile \n" +
                    "4.\tSearch\n" +
                    "5.\tExit\n ");
            System.out.print("Hãy chọn chức năng: ");
            int choice = CheckException.checkInteger();
            switch (choice) {
                case 1:
                    AddNew();
                    break;
                case 2:
                    mobileServices.delete();
                    break;
                case 3:
                    mobileServices.display();
                    break;
                case 4:
                    mobileServices.search();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Hãy chọn lại: ");
                    break;
            }
        }
    }

    private void AddNew() {
        System.out.println("Add new");
        System.out.println("1.\tAdd New Vip Mobile\n" +
                "2.\tAdd New Handle Mobile\n" +
                "3.\tExit\n ");
        System.out.print("Hãy chọn chức năng: ");
        int choice1 = CheckException.checkInteger();
        switch (choice1) {
            case 1:
                mobileServices.addNewVipMobile();
                break;
            case 2:
                mobileServices.addNewHandleMobile();
                break;
            case 3:
                break;
        }
    }
}
