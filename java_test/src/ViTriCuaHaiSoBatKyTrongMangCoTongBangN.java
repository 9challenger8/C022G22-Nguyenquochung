import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ViTriCuaHaiSoBatKyTrongMangCoTongBangN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number:");
        int n = scanner.nextInt();
        int[] arr = {1, 2, 3, 4,44,44,6,8,9};
        boolean check = true;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    System.out.println("Case "+ ": position " + i + "= " +arr[i]
                            + " and position " + (j) + "= "+ arr[j] +   " total= "+n);
                    check = false;
                }
            }
        }

        if (check){
            System.out.println("Not found.");
        }
    }
}
