import java.util.Arrays;

public class ThuatToanSapXep {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 3, 14, 5, 99, 7};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void insertionSort(int[] arr) {

    }


}
