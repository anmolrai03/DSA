package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityEle {
    public static int majorityElement(int []v) {
        /* 
        BRUTE FORCE 
        - take a element traverse through the entire array and store the frequency.
        if(frequency > n/2) ==> Majority element.

        O(n^2).

        // Code
        for(int i = 0; i < v.length ; i++){
            int count = 0;
            for(int j = 0; j < v.length ;j++){
                if(v[i] == v[j]){
                    count ++;
                }
            }
            if(count > v.length/2){
                return v[i];
            }
        }
        return -1;
        
        */
        

        /*
            BETTER
            - Use HashMap.
            - Traverse through the array and store the frequency of each element in the HashMap.
            - If the frequency is greater than n/2, return the element.
        */
        /*
        HashMap<Integer , Integer> mapp = new HashMap<>();
        for(int i = 0 ; i < v.length ; i++){
            if(mapp.containsKey(v[i])){
                mapp.put(v[i] , mapp.get(v[i]) + 1);
            } else {
                mapp.put(v[i] , 1);
            }
        }

        //for iterating over keys use 
        // Map.Entry<Integer, Integer> entry : map.entrySet() 
        for(Map.Entry<Integer,Integer> entry : mapp.entrySet()){
            if(entry.getValue() > v.length /2){
                return entry.getKey();
            }
        }
        return -1;
         */
        //Optimal - Moore's Voting algo.
        int count = 0;
        int element = 0; 
        for(int i = 0; i< v.length;i++){
            if(count == 0){
                count = 1;
                element = v[i];
            } else if(v[i] == element){
                count++;
            } else{
                count--;
            }
        }
        //check if count if majority
        int count1 = 0;
        for(int num: v){
            if(num == element) count1++;
        }
        if(count1>v.length/2){
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] v = {-53 ,75, 56, 56 ,56};
        System.out.println(majorityElement(v));
        // HashMap<Integer , Integer> mapp = new HashMap<>();
        // System.out.println(0);
        // mapp.put(1, 2);
        // mapp.put(2, 3);
        // mapp.put(3, 4);
        // System.out.println(mapp);
        // mapp.put(5,mapp.get(2) + 1);
        // System.out.println(mapp.get(5));
    }
}
