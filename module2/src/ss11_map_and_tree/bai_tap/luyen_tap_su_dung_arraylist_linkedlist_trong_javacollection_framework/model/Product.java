package ss11_map_and_tree.bai_tap.luyen_tap_su_dung_arraylist_linkedlist_trong_javacollection_framework.model;

public class Product {
     private int iD;
     private String name;
     private int price;

     public Product() {
     }

     public Product(int iD,String name , int price) {
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

     @Override
     public String toString() {
          return "Product{" +
                  "iD=" + iD +
                  ", name='" + name + '\'' +
                  ", price=" + price +
                  '}';
     }
}
