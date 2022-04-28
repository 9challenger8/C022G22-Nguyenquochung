package case_study.services.impl;

import case_study.models.person.Employee;
import case_study.services.IEmployeeServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagement implements IEmployeeServices {
    Scanner scanner= new Scanner(System.in);
    List<Employee> listEmployee=new ArrayList<>();
    SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
    static {

    }
    @Override
    public void displayList() {

    }

    @Override
    public void addNew() throws ParseException {
        System.out.print("Nhập id nhân viên: ");
        Integer iD= Integer.valueOf(scanner.nextLine());
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh của nhân viên: ");
        Date date = df.parse(scanner.nextLine());
        System.out.print("Nhập giới tính của nhân viên: ");
        String gender= scanner.nextLine();
        System.out.print("Nhập CMND của nhân viên: ");
        String numberCMND=scanner.nextLine();
        System.out.print("");




    }

    @Override
    public void edit() {

    }
}
