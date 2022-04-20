package ss12_thuat_toan_tim_kiem.bai_tap.tim_chuoi_tang_dan_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String str= scanner.nextLine();
        List<Character> max= new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i+1; j <str.length(); j++) {
                if(str.charAt(j)>list.getLast()){
                    list.add(str.charAt(j));
                }
            }
            if(list.size()> max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        System.out.println("Chuỗi con lớn nhất: ");
        for (Character ch: max) {
            System.out.print(ch);
        }
    }
}
