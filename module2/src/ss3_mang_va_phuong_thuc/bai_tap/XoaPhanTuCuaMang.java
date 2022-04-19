package ss3_mang_va_phuong_thuc.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuCuaMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] arr1={1,2,3,4,5,6,7};
        System.out.print(" Nhap phan tu can xoa: ");
        int x = scanner.nextInt();
        int indexDel=0;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]==x){
                indexDel=i;
                System.out.println("Vi tri phan tu can xoa: " + indexDel);
            }
        }
        for( int i=indexDel;i< arr1.length-1;i++){
            arr1[i]=arr1[i+1];
        }
        arr1[arr1.length-1]=0;
        for (int j = 0; j < arr1.length; j++) {
            System.out.print(arr1[j] + "\t");
        }
//        System.out.println(Arrays.toString(arr1));
    }
}
