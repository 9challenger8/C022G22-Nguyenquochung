public class TimTong4SoLonNhatVaNhoNhat {
    public static void main(String[] args) {
        int[] arr = {10,10,10,10,9};
        int sum = 0;
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (max < arr[i]){
                max = arr[i];
            }

            if (min >arr[i]){
                min=arr[i];
            }
        }
        System.out.println(sum - min);
        System.out.println(sum - max);
    }
}
