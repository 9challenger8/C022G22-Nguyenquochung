package ss10_danh_sach_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class DaoMangSoNguyen {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8};
        int[] newArr = new int[5];
        Stack<Integer> stack = new Stack<>();

        for (int j : arr) {
            stack.push(j);
        }
        for (int i = 0; i <arr.length; i++) {
            newArr[i]=stack.pop();
        }
        System.out.println(Arrays.toString(newArr));
    }
}
