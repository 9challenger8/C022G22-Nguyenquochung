package case_study.services.impl;

import case_study.models.person.Customers;
import case_study.services.ICustomerServices;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement implements ICustomerServices {
    static List<Customers> listCustomer = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    static {
        listCustomer.add(new Customers(1, "Hong Thuy", LocalDate.parse("1998-07-06"), "female", "2944783337", "095578327", "thuy@gmail.com", "Member", "89/Ho Tung Mau"));
        listCustomer.add(new Customers(2, "Eva", LocalDate.parse("1969-07-06"), "female", "29234383337", "095590827", "eva@gmail.com", "Diamond", "69/Nguyen Huu Tho"));
    }

    @Override
    public void displayList() {
        for (Customers customer : listCustomer) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.print("Nhập id khách hàng: ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh của khách hàng theo định dang yyyy-MM-dd: ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập giới tính của khách hàng: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập CMND của khách hàng: ");
        String numberCMND = scanner.nextLine();
        System.out.print("Nhập số điện thoại của khách hàng: ");
        String numberPhone = scanner.nextLine();
        System.out.print("Nhập email của khách hàng: ");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng: ");
        String guestType = scanner.nextLine();
        System.out.print("Nhập địa chỉ của khách hàng: ");
        String address = scanner.nextLine();
        listCustomer.add(new Customers(iD, name, date, gender, numberCMND, numberPhone, email, guestType, address));
    }

    @Override
    public void edit() {
        System.out.print("Nhập id khách hàng cần sửa: ");
        int iDEdit = Integer.parseInt(scanner.nextLine());
        boolean iDExist = false;
        Customers temp = null;
        for (Customers customer : listCustomer) {
            if (iDEdit == customer.getID()) {
                iDExist = true;
                temp = customer;
                break;
            }
        }
        if (!iDExist) {
            System.out.println("Id bạn nhập hiện không có.");
        } else {
            System.out.print("Nhập lại id khách hàng: ");
            temp.setID(Integer.parseInt(scanner.nextLine()));
            System.out.print("Nhập lại tên khách hàng: ");
            temp.setName(scanner.nextLine());
            System.out.print("Nhập lại ngày sinh của khách hàng theo định dang yyyy-MM-dd: ");
            temp.setBirthday(LocalDate.parse(scanner.nextLine()));
            System.out.print("Nhập lại giới tính của khách hàng: ");
            temp.setGender(scanner.nextLine());
            System.out.print("Nhập lại CMND của khách hàng: ");
            temp.setNumberCMND(scanner.nextLine());
            System.out.print("Nhập lại số điện thoại của khách hàng: ");
            temp.setNumberPhone(scanner.nextLine());
            System.out.print("Nhập lại email của khách hàng: ");
            temp.setEmail(scanner.nextLine());
            System.out.print("Nhập lại loại khách hàng: ");
            temp.setGuestType(scanner.nextLine());
            System.out.print("Nhập lại địa chỉ của khách hàng: ");
            temp.setAddress(scanner.nextLine());
        }
        displayList();
    }
}
