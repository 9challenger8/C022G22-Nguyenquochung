import java.util.*;

public class TestSimple {


    public static int[] sapXep(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {1, 46, 4, 6, 7, 46, 46, 7, 7};
        sapXep(arr);
        System.out.println(Arrays.toString(arr));
//        Set<Integer>  integerSet = new HashSet<>();
//
//        for (int j : arr) {
//            integerSet.add(j);
//        }

//        List<Integer> arrList = new ArrayList<>();
//        arrList.addAll(integerSet);
//        System.out.println(integerSet.g);
//        System.out.println(arrList.get(arrList.size() - 2));
    }
}

