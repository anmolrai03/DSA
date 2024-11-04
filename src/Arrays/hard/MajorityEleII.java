package Arrays.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityEleII {
    public static List< Integer > majorityElement(int []v) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        //Using HashMap.
        HashMap<Integer , Integer> map = new HashMap<>();
        //Storing in map
        for(int i: v){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        //Retriving value / frequency.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() >= v.length/3){
                list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        int[] v = {1,1,1,2,2,2};
        System.out.println(majorityElement(v));
    }
}
