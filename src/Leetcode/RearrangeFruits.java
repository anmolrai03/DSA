package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class RearrangeFruits {
   public static long minCost(int[] basket1, int[] basket2) {

      int m = basket1.length; int n = basket2.length;
      if( m == 0) return -1;

      HashMap<Integer, Integer> map1 = new HashMap<>();
      HashMap<Integer , Integer> map2 = new HashMap<>();

      for(int i = 0; i < m; i++){
         map1.put(basket1[i] , map1.getOrDefault(basket1[i] , 0)+1);
      }

      for(int i = 0; i < m; i++){
         map2.put(basket2[i] , map2.getOrDefault(basket2[i] , 0)+1);
      }

      long output = 0;

      // check if any new element is in either of map and frequecy is odd return -1;
      // if element is present in both sum of their freq % 2 == 0;
      // if same element is not present check for even count of the element.
      // in case of not present but even output += key * freq/2;
      if(map1.size() > map2.size()){
         for(Map.Entry<Integer, Integer> entry : map1.entrySet()){

            int key = entry.getKey(); int value = entry.getValue();

            if(map2.containsKey(key)){
               if( (map2.get(key) + value) % 2 != 0 ){
                  return -1;
               } else {
                  // like if one has 6 and one has 2 then 6+2 = 8/2 = 4 ,i.e , each should have 4
                  // to be equal so just | 6-4 | = | 2 - 4 | should be transfered , this will be
                  // multiplied by key to get min cost as key is same. no need to check min.
                  output += (long) key * Math.abs( value - (map2.get(key) + value)/2 );
               }
            } else {
               if(value %2 != 0){
                  return -1;
               }
            }
         }
      }


//      System.out.println(map1);
//      System.out.println(map2);


      return output;
   }

   public static void main(String[] args) {
      int[] b1 = {4,2,2,2}; int[] b2 = {1,4,1,2};
      int[] basket1 = {2,3,4,1} ,  basket2 = {3,2,5,1};
      System.out.println(minCost(b1 , b2));
      System.out.println(minCost(basket1 , basket2));
   }
}
