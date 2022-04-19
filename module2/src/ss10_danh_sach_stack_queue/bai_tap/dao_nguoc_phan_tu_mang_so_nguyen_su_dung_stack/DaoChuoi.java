package ss10_danh_sach_stack_queue.bai_tap.dao_nguoc_phan_tu_mang_so_nguyen_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class DaoChuoi {
    public static void main(String[] args) {
        String str = "ultimate la ky nang toi thuong";
        String[] words = str.split("\\s",0);
        Stack<String> stack= new Stack<>();
        String[] newWords = new String[6];
        for (String w: words) {
            System.out.println(w);
        }
        for (String word : words) {
            stack.push(word);
        }
        for (int i=0;i<words.length;i++){
            newWords[i]=stack.pop();
        }
        System.out.println(Arrays.toString(newWords));
    }
}
