package ss16_file_and_serialization.bai_tap.quan_ly_san_pham_luu_ra_nhi_phan;

import ss16_file_and_serialization.thuc_hanh.doc_va_ghi_danh_sach_sinh_vien_ra_file_nhi_phan.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product implements Serializable {
    private int iD;
    private String name;
    private int price;
    private static final List<Product> list = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    static {
        Product product = new Product(1, "car", 4000);
        Product product1 = new Product(2, "chicken", 20);
        list.add(product);
        list.add(product1);
        writeToFile("src/ss16_file_and_serialization/bai_tap/quan_ly_san_pham_luu_ra_nhi_phan/products.txt", list);
    }

    public Product() {
    }

    public Product(int iD, String name, int price) {
        this.name = name;
        this.iD = iD;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void addProduct() {
        System.out.print("Nhap id san pham: ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("Nhap gia san pham: ");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(iD, name, price);
        list.add(product);
        writeToFile("src/ss16_file_and_serialization/bai_tap/quan_ly_san_pham_luu_ra_nhi_phan/products.txt", list);
    }

    public void displayProducts() {
        List<Product> productDataFromFile = readDataFromFile("src/ss16_file_and_serialization/bai_tap/quan_ly_san_pham_luu_ra_nhi_phan/products.txt");
        for (Product o : productDataFromFile) {
            System.out.println(o);
        }
    }

    public void searchProduct() {
        System.out.print("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        if (checkName(name)) {
            for (Product product : list) {
                if (product.getName().equals(name))
                    System.out.println(product);
            }
        } else {
            System.out.print("Sản phẩm bạn tìm hiện không có.");
        }
    }

    private boolean checkName(String name) {
        for (Product product : list) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
