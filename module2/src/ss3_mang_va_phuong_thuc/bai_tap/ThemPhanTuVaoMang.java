package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[7];
        for (int i = 0; i < 5; i++) {
            arr1[i] = (int) (Math.random() * 99);
        }
        for (int a : arr1) {
            System.out.print(a + "\t");
        }
        System.out.print("Nhap phan tu can chen: ");
        int x = scanner.nextInt();
        System.out.print("Nhap vi tri can chen: ");
        int indexAdd = scanner.nextInt();
        if (indexAdd <= -1 || indexAdd > arr1.length - 1) {
            System.out.println("Không chèn được phần tử vào mảng");
        }

        for (int i = arr1.length - 1; i > indexAdd; i--) {
            arr1[i] = arr1[i - 1];
        }
        arr1[indexAdd] = x;
        for (int a : arr1) {
            System.out.print(a + "\t");
        }
    }
}
