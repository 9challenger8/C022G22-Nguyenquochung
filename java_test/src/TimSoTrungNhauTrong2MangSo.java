public class TimSoTrungNhauTrong2MangSo {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {3,4,5,7,9,3,6,4,2};

        System.out.println("Số trùng lặp: ");

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j]){
                    System.out.print(arr1[i]+ " ");
                    break;
                }
            }
        }
    }
}
