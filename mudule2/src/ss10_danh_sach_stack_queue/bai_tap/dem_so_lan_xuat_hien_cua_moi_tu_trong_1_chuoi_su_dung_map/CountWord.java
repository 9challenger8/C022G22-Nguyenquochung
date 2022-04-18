package ss10_danh_sach_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_moi_tu_trong_1_chuoi_su_dung_map;

import java.util.*;


public class CountWord {
    public static void main(String[] args) {
        String str = "abap1023912903";
        str = str.replaceAll(",","");
        String[] arr = str.split("");
        String key;
        Integer value;
        Map<String, Integer> map = new TreeMap<>();
        for (String s : arr) {
            key = s;
            if (map.containsKey(key)) {
                value = map.get(key);
                map.remove(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        Set<String> set=map.keySet();
        for (String o : set) {
            key = o;
            System.out.println("Từ " + key + " xuất hiện " + map.get(key) + " lần");
        }
    }
}
