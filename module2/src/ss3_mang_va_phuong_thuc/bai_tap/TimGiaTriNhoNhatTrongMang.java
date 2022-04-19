package ss3_mang_va_phuong_thuc.bai_tap;


import java.util.Arrays;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 99);
        }
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Min: " + min);
    }
}
