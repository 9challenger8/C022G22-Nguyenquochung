package ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.service;

import ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.model.Product;

import java.util.*;

public class ProductManager implements ProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> list = new LinkedList<>();

   static {
       list.add(new Product(1,"Dien thoai",5));
       list.add(new Product(2,"Dien may",35));
       list.add(new Product(3,"tu lanh",55));
       list.add(new Product(4,"tivi",15));

   }

    public void addProduct() {
        System.out.print("Nhập id sản phẩm: ");
        int iD = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(iD, name, price);
        list.add(product);
    }

    public void displayProduct() {
        for (Product x : list) {
            System.out.println(x);
        }
    }

    public void deleteProduct() {
        System.out.println(" Nhập ID cần xóa: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        if(checkExists(idDelete)){
            for (int i = 0; i < list.size(); i++) {
                if (idDelete == list.get(i).getID()) {
                    list.remove(i);
                    break;
                }
            }
        } else {
            System.out.println(" ID bạn nhập hiện không có. ");
        }
    }

    private Boolean checkExists(int idDelete) {
        for (Product product : list) {
            if (idDelete == product.getID()) {
                return true;
            }
        }
        return false;
    }

    public void searchProduct() {
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();
        if (checkName(name)) {
            for (Product product : list) {
                if (product.getName().contains(name)) {
                    System.out.println(product);
                }
            }
        } else {
            System.out.println(" Sản phẩm bạn tìm hiện không có");
        }
    }

    private Boolean checkName(String name){
        for (Product product : list) {
            if (product.getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public void editProduct() {
        System.out.println(" Nhập ID cần sửa:");
        int iDCheck = Integer.parseInt(scanner.nextLine());
        for (Product product : list) {
            if (iDCheck == product.getID()) {
                System.out.print("Nhập lại id sản phẩm: ");
                product.setID(Integer.parseInt(scanner.nextLine()));
                System.out.print("Nhập lại tên sản phẩm: ");
                product.setName(scanner.nextLine());
                System.out.print("Nhập lại giá sản phẩm: ");
                product.setPrice(Integer.parseInt(scanner.nextLine()));
            } else {
                System.out.println(" ID bạn nhập hiện không có.");
            }
        }
        displayProduct();
    }
    public void sortDecreaseProduct(){
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
    }

    public void sortAscendingProduct(){
        Collections.sort(list, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

}





