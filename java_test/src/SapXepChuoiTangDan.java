import java.util.Arrays;

public class SapXepChuoiTangDan {


    public static void main(String[] args) {
        String str = "shark small";

        System.out.println(str.length());

        int[] arr = {2,4,3,5,6,6,7,7,7,7,9,9,9};

        int count = 0;

        for (int i = 0; i < arr.length-1; i++) {
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
               count++;
            }
            if(count==2){
                System.out.println(arr[i+1]);
                break;
            }
        }
    }
}
