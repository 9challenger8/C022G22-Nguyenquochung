package ss13_thuat_toan_sap_xep.thuc_hanh.cai_dat_thuat_toan_sap_xep_noi_bot;

import java.util.Arrays;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5,17, 6, 1, -2, 3, 14, 12};
    
    public static void bubbleSort(int[]list){
        boolean needNextPass=true;
        for (int i = 1; i < list.length && needNextPass ; i++) {
            needNextPass=false;
            for (int j = 0; j < list.length-i; j++) {
                if(list[j]>list[j+1]){
                    int temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;

                    needNextPass=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(list);
        for (int j : list) System.out.print(j + " ");

        System.out.println(Arrays.toString(list));
    }


}
