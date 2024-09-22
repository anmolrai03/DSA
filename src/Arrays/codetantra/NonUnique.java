package Arrays.codetantra;
import java.util.*;
public class NonUnique {
    public static int nonUniqueCount(List<Integer> arr){
        Map<Integer,Integer> mapp = new HashMap<>();
        for(int i = 0 ; i<arr.size() ; i++){
            int key = arr.get(i);
            if(mapp.containsKey(key)){
                mapp.put(key,mapp.get(key)+1);
            }
            else{
                mapp.put(key,1);
            }
        }
        int count = 0;
        for(int value: mapp.values()){
            if(value != 1){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        arr.add(4);
        arr.add(4);
        System.out.println(nonUniqueCount(arr));

        // Map<Integer,Integer> mapp = new HashMap<>();
        // mapp.put(1,3);
        // mapp.put(2,5);
        // System.out.println(mapp.containsKey(2));
        // mapp.put(2,mapp.get(2)+1);
        // System.out.println(mapp);
    }
}
