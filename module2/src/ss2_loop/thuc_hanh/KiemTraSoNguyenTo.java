package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number= scanner.nextInt();
        boolean check =true;
        if(number<2){
            check = false;
        }else {
            for(int i=2;i<number;i++){
                if(number%i==0){
                    check = false;
                    break;
                }
            }
        }
        if(check){
            System.out.println(number +" la so nguyen to.");
        }else {
            System.out.println(number+ " khong la so nguyen to.");
        }
    }
}
