import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<Integer,String> hm = new HashMap<>();

        hm.put(333,"Hung");
        hm.put(111,"Hung");
        hm.put(241,"Hung");
        hm.put(444,"Hung");
        System.out.println(hm);
        Map<Integer,String> lhm = new LinkedHashMap<>();
        lhm.put(333,"Hung");
        lhm.put(111,"Hung");
        lhm.put(241,"Hung");
        lhm.put(444,"Hung");

        System.out.println(lhm);
    }
}
