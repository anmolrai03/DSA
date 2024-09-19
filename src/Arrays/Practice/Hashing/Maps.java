package Arrays.Practice.Hashing;

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        HashMap <Integer , Integer> map = new HashMap<>();

        map.put(1, 2);
        map.put(2, 4);
        System.out.println(map);
        System.out.println(map.keySet());
        System.out.println(map.containsValue(2 ));
    }
}
