package ss14_xu_li_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class TriangleMain {

    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        try {
            System.out.print("Enter size a: ");
            int a= Integer.parseInt(scanner.nextLine());
            System.out.print("Enter size b: ");
            int b=Integer.parseInt(scanner.nextLine());
            System.out.print("Enter size c: ");
            int c=Integer.parseInt(scanner.nextLine());
            Triangle triangle=new Triangle(a,b,c);
            System.out.println("Triangle perimeter: "+triangle.getPerimeter());
        }catch (IllegalTriangleException e){
            System.err.println(e.getMessage());
        }catch (NumberFormatException e){
            System.err.println("Error");
        }
    }
}
