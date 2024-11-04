package Arrays.hard;

import java.util.HashMap;

public class XorSumSubarray {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        //Brute force apporch
        /*
        int subArrayCount = 0;
        for(int i = 0; i< a.length; i++){
            int xor = 0;
            for(int j = i ; j< a.length ; j++){
                xor ^= a[j];
                if(xor == b){
                    subArrayCount++;
                }
            }
        }
        return subArrayCount;

        */

        //Optimal
        /*
            - x = xR ^ k
        */
        int xr = 0;
        int count = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(xr,1);
        for(int num : a){
            xr = xr ^ num;
            int x = xr ^ b;
            if(map.containsKey(x)){
                count += map.get(x);
            }
            if(map.containsKey(xr)){
                map.put(xr , map.get(xr)+1);
            }else{
                map.put(xr , 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        System.out.println(subarraysWithSumK(a,6));
    }
}
