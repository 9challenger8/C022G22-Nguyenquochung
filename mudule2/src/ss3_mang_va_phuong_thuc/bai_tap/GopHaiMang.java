package ss3_mang_va_phuong_thuc.bai_tap;

public class GopHaiMang {
    public static void main(String[] args) {
        int[] arr1 = {4,5,6,4,3,2};
        int[] arr2 = {5,7,6};
        int[] arr3 = new int[arr1.length + arr2.length];
        int j = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                if (j<arr2.length) {
                    arr3[i] = arr2[j];
                    j++;
                }
            }
        }
        System.out.print("Hien thi mang: ");
        for (int a : arr3) {
            System.out.print(a+ "\t");
        }
    }
}
