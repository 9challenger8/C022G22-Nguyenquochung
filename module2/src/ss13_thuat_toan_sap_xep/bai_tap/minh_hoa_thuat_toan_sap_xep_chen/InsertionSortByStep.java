package ss13_thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class InsertionSortByStep {
    static double[] list = {1, 9, 4.5, 6.6, 5.7, -4.5};
    public static void insertionSort(double[] list) {
        double x;
        int pos;
        for (int i = 1; i < list.length; i++) {
            x = list[i];
            pos = i;
            System.out.println("Gán x ở vị trí "+i+" giá trị = "+list[i]);
            while (pos > 0 && x < list[pos - 1]) {
                System.out.println("Đổi giá trị vị trí "+pos+" = giá trị vị trí "+(pos -1));
                System.out.println(list[pos]+ " bằng " + list[pos-1]);
                list[pos] = list[pos - 1];
                pos--;
            }
            System.out.println("Gán lại giá trị x vị trí " + pos);
            System.out.println("Giá trị = "+ list[pos]);
            list[pos] = x;
            System.out.println("In mảng được sắp xếp lần thứ " + i);
            System.out.println(Arrays.toString(list));
        }
    }
    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
