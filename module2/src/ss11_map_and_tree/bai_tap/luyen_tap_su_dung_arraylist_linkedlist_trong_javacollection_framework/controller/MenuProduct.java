package ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.controller;

import ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.service.ProductManager;
import ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.service.ProductService;

import java.util.Scanner;

public class MenuProduct {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductService productManager = new ProductManager();

    public void display() {
        int choice;
        while (true) {
            System.out.println("Chào mừng bạn đến app quản lý sản phẩm: ");
            System.out.print("1.Thêm sản phẩm\n" +
                    "2.Sửa thông tin sản phẩm theo id\n" +
                    "3.Xoá sản phẩm theo id\n" +
                    "4.Hiển thị danh sách sản phẩm\n" +
                    "5.Tìm kiếm sản phẩm theo tên\n" +
                    "6.Sắp xếp sản phẩm tăng dần theo giá\n" +
                    "7.Sắp xếp sản phẩm giảm dần theo giá \n");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.editProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.displayProduct();
                    break;
                case 5:
                    productManager.searchProduct();
                    break;
                case 6:
                    productManager.sortAscendingProduct();
                    break;
                case 7:
                    productManager.sortDecreaseProduct();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Chọn lại ");
                    break;
            }
        }
    }
}
