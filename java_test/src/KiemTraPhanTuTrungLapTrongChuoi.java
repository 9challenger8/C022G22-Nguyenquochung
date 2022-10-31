import java.util.ArrayList;
import java.util.Arrays;

public class KiemTraPhanTuTrungLapTrongChuoi {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("hhuhnnnnuuuugng123* h");
        char[] chars = str.toString().toCharArray();
        System.out.println(Arrays.toString(chars));
        StringBuilder str1 = new StringBuilder();

        int[] check = new int[256];


        for (int i = 0; i < chars.length; i++) {
            check[chars[i]]++;
        }


        for (int i = 0; i <chars.length; i++) {
            int count = 0;
            for (int j = i+1; j < chars.length;  j++) {
                if(chars[i]==chars[j]){
                    count++;
                }
            }
            if (count == 0){
                System.out.print(chars[i] + " = " + check[chars[i]] + ", ");
                str1.append(chars[i]);
            }

        }

        System.out.println();
        System.out.print(str1);


    }
}
