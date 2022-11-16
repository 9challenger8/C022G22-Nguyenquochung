import java.util.*;

public class DemoCollectionFramework {


    public static void main(String[] args) {


//        {1=Hung, 2=Win, 3=Win, null=Bear, 6=Win}
//        Getting value for key 'one': Hung
//        Size of the map: 5
//        Is map empty? false
//        Contains key '2'? true
//        Contains value 'Bear'  true
//        {2=Win, 3=Win, null=Bear, 6=Win}

        Map<Integer, String> hm1 = new HashMap<>();

//        hm1.put(1, "Hung");
//        hm1.put(2, "Bear");
//        hm1.put(3, ".net");
//        hm1.put(4, ".net");

        System.out.println(hm1);
        hm1.remove(3);

        for (Map.Entry<Integer,String> mapElement : hm1.entrySet()) {
            int key = mapElement.getKey();

            String value =  mapElement.getValue();

            System.out.println(key + " : " + value);

        }

//        Map<Integer, String> tm = new TreeMap<>();
//
//        tm.put(3, "Hung");
//        tm.put(2, "Hung");
//        tm.put(1, "Win");
//        tm.put(4, "For");
//        tm.put(-1,"Bear");
//        tm.put(-10,"Hung");
//
//        System.out.println(tm);
//        System.out.println(tm.get(2));
//        tm.remove(4);
//        System.out.println(tm);
//
//        for (Map.Entry<Integer,String> mapElement : tm.entrySet()) {
//            int key =  mapElement.getKey();
//
//            String value = mapElement.getValue();
//
//            System.out.println(key + " : " + value);
//        }


//        Map<String,String> lhm = new LinkedHashMap<>();
//        lhm.put("1", "Hung");
//        lhm.put("2", "Win");
//        lhm.put("3", "Win");
//        lhm.put(null,"Tiger");
//        lhm.put("6","Win");
//        lhm.put(null,"Bear");
//        System.out.println(lhm);
//        System.out.println("Getting value for key 'one': " + lhm.get("1"));
//        System.out.println("Size of the map: " + lhm.size());
//        System.out.println("Is map empty? " + lhm.isEmpty());
//        System.out.println("Contains key '2'? " + lhm.containsKey("2"));
//        System.out.println("Contains value 'Bear'  " + lhm.containsValue("Bear"));
//        lhm.remove("1");
//        System.out.println(lhm);
    }


}
