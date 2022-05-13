package thi_ket_thuc_module2.services.impl;

import thi_ket_thuc_module2.common.CheckException;
import thi_ket_thuc_module2.common.ReadAndWrite;
import thi_ket_thuc_module2.models.HandleMobile;
import thi_ket_thuc_module2.models.Mobile;
import thi_ket_thuc_module2.models.VipMobile;
import thi_ket_thuc_module2.services.IServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MobileServices implements IServices {
    private static final Scanner scanner = new Scanner(System.in);
    static List<HandleMobile> listHandleMobile = new ArrayList<>();
    static List<VipMobile> listVipMobile = new ArrayList<>();
    static List<Mobile> mobileList=new ArrayList<>();


    @Override
    public void addNewHandleMobile() {
        mobileList=ReadAndWrite.readMobile();
        System.out.print("Nhập id : ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên điện thoại: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá của điện thoại: ");
        String costMobile = scanner.nextLine();
        System.out.print("Nhập số lượng của điện thoại: ");
        String amountOfMobile = scanner.nextLine();
        System.out.print("Nhập nhà sản xuất của điện thoại: ");
        String manufactorMobile = scanner.nextLine();
        System.out.print("Nhập khu vực xách tay của điện thoại: ");
        String countryHandle = scanner.nextLine();
        System.out.print("Nhập trạng thái: ");
        String trangThai = scanner.nextLine();
        HandleMobile handleMobile = new HandleMobile(iD, name, costMobile, amountOfMobile, manufactorMobile, countryHandle, trangThai);
        mobileList.add(handleMobile);
        ReadAndWrite.writeAll(mobileList);;
    }

    @Override
    public void addNewVipMobile() {
        mobileList=ReadAndWrite.readMobile();
        System.out.print("Nhập id : ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên điện thoại: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá của điện thoại: ");
        String costMobile = scanner.nextLine();
        System.out.print("Nhập số lượng của điện thoại: ");
        String amountOfMobile = scanner.nextLine();
        System.out.print("Nhập nhà sản xuất của điện thoại: ");
        String manufactorMobile = scanner.nextLine();
        System.out.print("Nhập thời gian bảo hành của điện thoại: ");
        String timeBaoHanh = scanner.nextLine();
        System.out.print("Nhập phạm vi bảo hành: ");
        String areaBaoHanh = scanner.nextLine();
        VipMobile vipMobile = new VipMobile(iD, name, costMobile, amountOfMobile, manufactorMobile, timeBaoHanh, areaBaoHanh);
        mobileList.add(vipMobile);
        ReadAndWrite.writeAll(mobileList);
    }

    @Override
    public void delete() {
        mobileList=ReadAndWrite.readMobile();
        boolean check = false;
        System.out.println("*---Delete Mobile  !!!");
        System.out.println("enter the id want delete");
        Integer idDell = Integer.parseInt(scanner.nextLine());
        for (Mobile mobile : mobileList) {
            if (mobile.getID() == idDell) {
                check = true;
                break;
            }
        }
        if (check) {
            while (check) {
                System.out.print("you want delete Movie: \n" +
                        "1.yes"+"\n"+
                        "2.no\n"+
                        "you choice : ");
                int choice =  CheckException.checkInteger();
                switch (choice){
                    case 1:
                        for (int i = 0; i < mobileList.size(); i++) {
                            if (mobileList.get(i).getID().equals(idDell)) {
                                mobileList.remove(i);
                                break;
                            }
                        }
                        System.out.println("***Deleted!!!");
                        check = false;
                        break;
                    case 2:
                        System.out.println("no");
                        check = false;
                        break;
                    default:
                        System.out.println("Re- choice: ");
                }
            }
            ReadAndWrite.writeAll(mobileList);
        }else {
            System.out.println("dont find id!!!");
        }
    }


    @Override
    public void display() {
        mobileList=ReadAndWrite.readMobile();
        for (Mobile mobile : mobileList) {
            System.out.println(mobile.getInFor());
        }
    }

    @Override
    public void search() {
        mobileList=ReadAndWrite.readMobile();
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        if (checkName(name)) {
            for (Mobile mobile : mobileList) {
                if (mobile.getNameMobile().contains(name)) {
                    System.out.println(mobile);
                }
            }
        } else {
            System.out.println(" Sản phẩm bạn tìm hiện không có");
        }
    }
    private Boolean checkName(String name){
        for (Mobile mobile : mobileList) {
            if (mobile.getNameMobile().contains(name)) {
                return true;
            }
        }
        return false;
    }
}
