package bai_tap_nhom;

import java.util.Scanner;

public class bai_1 {
    public static void main(String[] args) {
            int h=5;
            int m=h;
            int n=h;
        for (int i = 1; i < h; i++)
        {
            for (int j = 1; j <= 2 * h - 1; j++)
            {
                if (i == h|| j == m || j == n ){
                    System.out.print(i+1);
                }
                else{
                System.out.print(" ");
                }
            }
            m--;
            n++;
            System.out.print("\n");
        }

















    }

}
