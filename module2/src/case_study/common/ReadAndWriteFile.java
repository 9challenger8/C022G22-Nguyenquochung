package case_study.common;

import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customers;
import case_study.models.person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteFile {
    public static final String EMPLOYEE_PATH = "src/case_study/common/data/employee.csv";
    public static final String CUSTOMER_PATH = "src/case_study/common/data/customer.csv";
    public static final String HOUSE_PATH = "src/case_study/common/data/house.csv";
    public static final String ROOM_PATH = "src/case_study/common/data/room.csv";
    public static final String VILLA_PATH = "src/case_study/common/data/villa.csv";

    private static void WriteToFile(String filePath, List<String> list) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String str : list) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployee( List<Employee> employeeList) {
        List<String> employees = new ArrayList<>();

        for (Employee employee : employeeList) {
            employees.add(employee.getInFor());
        }
        WriteToFile(EMPLOYEE_PATH, employees);
    }

    public static void writeHouse( Map<House, Integer> houseList) {
        try {
            FileWriter writer = new FileWriter(HOUSE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Map.Entry<House, Integer> facility : houseList.entrySet()) {
                bufferedWriter.write(facility.getKey() + ", " + facility.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRoom( Map<Room, Integer> roomList) {
        try {
            FileWriter writer = new FileWriter(ROOM_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Map.Entry<Room, Integer> facility : roomList.entrySet()) {
                bufferedWriter.write(facility.getKey() + ", " + facility.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeVilla( Map<Villa, Integer> villaList) {
        try {
            FileWriter writer = new FileWriter(VILLA_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Map.Entry<Villa, Integer> facility : villaList.entrySet()) {
                bufferedWriter.write(facility.getKey() + ", " + facility.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Room, Integer> readRoom() {
        Map<Room, Integer> roomList = new LinkedHashMap<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(ROOM_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(", ");
                roomList.put(new Room(lines[0], lines[1], Double.parseDouble(lines[2])
                        , Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6]), Integer.parseInt(lines[7]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    public static Map<Villa, Integer> readVilla() {
        Map<Villa, Integer> villaList = new LinkedHashMap<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(VILLA_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(", ");
                villaList.put(new Villa(lines[0], lines[1], Double.parseDouble(lines[2]), Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6], Double.parseDouble(lines[7]), Integer.parseInt(lines[8])), Integer.parseInt(lines[9]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaList;
    }

    public static Map<House, Integer> readHouse() {
        Map<House, Integer> houseList = new LinkedHashMap<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(HOUSE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(", ");
                houseList.put(new House(lines[0], lines[1], Double.parseDouble(lines[2]),
                        Integer.parseInt(lines[3]), Integer.parseInt(lines[4]), lines[5], lines[6], Integer.parseInt(lines[7])), Integer.parseInt(lines[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseList;
    }

    public static void writeCustomer( List<Customers> customers) {
        List<String> strings = new LinkedList<>();

        for (Customers customer : customers) {
            strings.add(customer.getInFor());
        }
        WriteToFile(CUSTOMER_PATH, strings);
    }

    public static List<Employee> readEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(EMPLOYEE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(", ");
                employeeList.add(new Employee(Integer.parseInt(lines[0]), lines[1], LocalDate.parse(lines[2]), lines[3], lines[4], lines[5], lines[6], lines[7], lines[8], Integer.parseInt(lines[9])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static List<Customers> readCustomer() {
        List<Customers> customersList = new LinkedList<>();
        String[] lines = null;
        String line = null;
        try {
            FileReader fileReader = new FileReader(CUSTOMER_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(", ");
                customersList.add(new Customers(Integer.parseInt(lines[0]), lines[1], LocalDate.parse(lines[2]), lines[3], lines[4], lines[5], lines[6], lines[7], lines[8]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersList;
    }

    public static void writeEmployee1(String pathFile, List<Employee> employeeList) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Employee employee : employeeList) {
                bufferedWriter.write(employee.getInFor());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
