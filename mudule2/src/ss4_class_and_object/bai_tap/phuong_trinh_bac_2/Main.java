package ss4_class_and_object.bai_tap.phuong_trinh_bac_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        QuadraticEquation equa= new QuadraticEquation(a,b,c);
        System.out.printf(equa.calculate());
    }
}
