import java.util.Arrays;

public class TimSoLonThuHai {


    public static void main(String[] args) {

        int[] arr = {1,3,4,4,4,3,3,2};

        //Cach 1:
//        sapXep(arr);
//        int second = 0;
//        for (int i=arr.length-1;i>0;i--){
//            if (arr[i]>arr[i-1]) {
//                second=arr[i-1];
//                break;
//            }
//        }

        //Cach 2:
        int max =arr[0];
        int max2 =arr[0];

        for (int j : arr) {

            if (j > max) {
                max2 = max;
                max = j;
            }

            if (j > max2 && j < max) {
                max2 = j;
            }

            if(max==max2){
                max2=j;
            }
        }

        System.out.println(max2);

    }

    public static int[] sapXep(int[] arr){
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i <arr.length-1 ; i++) {
            System.out.println(i);
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]<arr[j]){
                    int dem=arr[i];
                    arr[i]=arr[j];
                    arr[j]=dem;

                }
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }

}
