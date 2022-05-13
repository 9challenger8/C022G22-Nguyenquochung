package case_study.services.impl;

import case_study.common.ReadAndWriteFile;
import case_study.models.person.Employee;
import case_study.services.IEmployeeServices;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class EmployeeManagement implements IEmployeeServices {
    static final Scanner scanner = new Scanner(System.in);
    static List<Employee> listEmployee = new ArrayList<>();

    public static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    static {
        listEmployee.add(new Employee(1, "Dung", LocalDate.parse("2021-01-01"), "male", "2416849494", "0944569998", "ui@gmail.com", "trung cap", "giam doc", 5000));
        listEmployee.add(new Employee(2, "Jon", LocalDate.parse("2021-01-01"),
                "female", "2416278494", "0944537998",
                "i@gmail.com", "dai hoc", "giam sat", 3000));
        ReadAndWriteFile.writeEmployee(listEmployee);

    }

    @Override
    public void displayList() {
        List<Employee> employeeList = ReadAndWriteFile.readEmployee();
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        listEmployee = ReadAndWriteFile.readEmployee();
        System.out.print("Nhập id nhân viên: ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh của nhân viên theo định dang yyyy-MM-dd: ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Nhập giới tính của nhân viên: ");
        String gender = scanner.nextLine();
        System.out.print("Nhập CMND của nhân viên: ");
        String numberCMND = scanner.nextLine();
        System.out.print("Nhập số điện thoại của nhân viên: ");
        String numberPhone = scanner.nextLine();
        System.out.print("Nhập email của nhân viên: ");
        String email = scanner.nextLine();
        System.out.println("Nhập trình độ của nhân viên: ");
        String level = scanner.nextLine();
        System.out.print("Nhập vị trí của nhân viên: ");
        String position = scanner.nextLine();
        System.out.println("Nhập lương của nhân viên: ");
        int salary = Integer.parseInt(scanner.nextLine());
        Employee employee = new Employee(iD, name, date, gender, numberCMND, numberPhone, email, level, position, salary);
        listEmployee.add(employee);
        ReadAndWriteFile.writeEmployee(listEmployee);
    }

    @Override
    public void edit() {
        listEmployee = ReadAndWriteFile.readEmployee();
        System.out.print("Nhập id nhân viên cần sửa:");
        int iDEdit = Integer.parseInt(scanner.nextLine());
        boolean iDExist = false;
        Employee temp = null;
        for (Employee employee : listEmployee) {
            if (iDEdit == employee.getID()) {
                iDExist = true;
                temp = employee;
                break;
            }
        }
        if (!iDExist) {
            System.out.println("Id bạn nhập hiện không có.");
        } else {
            System.out.print("Nhập lại id nhân viên: ");
            temp.setID(Integer.parseInt(scanner.nextLine()));
            System.out.print("Nhập lại tên nhân viên: ");
            temp.setName(scanner.nextLine());
            System.out.print("Nhập lại ngày sinh của nhân viên theo định dạng yyyy-MM-dd: ");
            temp.setBirthday(LocalDate.parse(scanner.nextLine()));//yyyy-MM-dd
            System.out.print("Nhập lại giới tính của nhân viên: ");
            temp.setGender(scanner.nextLine());
            System.out.print("Nhập lại CMND của nhân viên: ");
            temp.setNumberCMND(scanner.nextLine());
            System.out.print("Nhập lại số điện thoại của nhân viên: ");
            temp.setNumberPhone(scanner.nextLine());
            System.out.print("Nhập lại email của nhân viên: ");
            temp.setEmail(scanner.nextLine());
            System.out.println("Nhập lại trình độ của nhân viên: ");
            temp.setLevel(scanner.nextLine());
            System.out.print("Nhập lại vị trí của nhân viên: ");
            temp.setPosition(scanner.nextLine());
            System.out.println("Nhập lại lương của nhân viên: ");
            temp.setSalary(Integer.parseInt(scanner.nextLine()));
        }
    }
}





