package ss16_file_and_serialization.bai_tap.quan_ly_san_pham_luu_ra_nhi_phan;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static final Product product = new Product();

    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("Chào mừng các bạn: ");
            System.out.print("1.Thêm sản phẩm\n" +
                    "2.Hiển thị sản phẩm\n" +
                    "3.Tìm kiếm sản phẩm\n");
            System.out.println("Chọn chức năng:");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Product.addProduct();
                    break;
                case 2:
                    product.displayProducts();
                    break;
                case 3:
                    product.searchProduct();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("Chọn lại:");
            }
        }
    }
}
