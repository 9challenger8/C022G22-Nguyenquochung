package ss19_string_regex.bai_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaiTapGiaiThuatTuan12 {
    public static void main(String[] args) {
        int[][] arg1={{1,2},{3,4}};
        System.out.println(Arrays.toString(solution(arg1)));
    }

    public static Integer[] solution(int[][] arg1) {
        List<Integer> listPrime= new ArrayList<>();

        for(int i=0;i<arg1.length;i++)
            for (int j = 0;j<arg1[i].length; j++) {
                if (isPrime(arg1[i][j])) {
                    listPrime.add(arg1[i][j]);
                }
            }
        return listPrime.toArray(new Integer[0]);
    }

    public static boolean isPrime( int n){
        if(n<2){
            return false;
        }
        else {
            for(int i=2;i<n;i++){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
