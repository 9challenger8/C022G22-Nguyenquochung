public class ThuatToanSapXep {

    int[] bubbleSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i]<arr[j]){
                    int temp = arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                }

            }
        }
        return arr;
    }

    void insertionSort(int[] arr){

    }



}
