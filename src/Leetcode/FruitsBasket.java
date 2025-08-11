package Leetcode;

import javax.imageio.ImageTranscoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FruitsBasket {

   public static int totalFruit(int[] fruits) {

      int n = fruits.length;
      if( n == 0) return 0;
      if(n < 2) return n;

      HashMap<Integer, Integer> basket = new HashMap<>();
      int maxFruits = 0;

      int left = 0 , right = 0;

      while(right < n ){

         if(basket.isEmpty()){
            basket.put(fruits[right] , right);
            right++;
            continue;
         }

         if( basket.containsKey(fruits[right]) ){
            basket.replace(fruits[right] , right);
         } else {

            if(basket.size() < 2 ){
               // basket size if less than 2 , then add it in hashMap.
               basket.put(fruits[right] , right);
            } else{
               // basket is already full.
               maxFruits = Math.max(maxFruits , right -left);
               // go to last index of fruits[left] to make element in map less than 1.
               // remove the one with less index and then left = thatIdx + 1;

               int toRemove = -1;
               int idx = Integer.MAX_VALUE;
               for(Map.Entry<Integer , Integer> entry: basket.entrySet()){
                  if( entry.getValue() < idx ){
                     idx = entry.getValue();
                     toRemove = entry.getKey();
                  }
               }

               left = idx + 1;
               basket.remove(toRemove);
               basket.put(fruits[right] , right);

//               int toRemove = fruits[left];
//               left = basket.get(fruits[left]) + 1;
//               basket.remove(toRemove);
//               basket.put(fruits[right] , right);
            }
         }
         right++;
      }

      if(left < n){
         maxFruits = Math.max(maxFruits , right - left);
      }


      return maxFruits;
   }

   public static void main(String[] args) {
//      HashMap<Integer, Integer> map = new HashMap<>();
//      map.put(0 , 1);
//      map.put(1 , 2);
//      Set<Map.Entry<Integer, Integer>> arr = map.entrySet();

//      for(Map.Entry<Integer , Integer> entry: map.entrySet()){
//         System.out.println(entry);
//      }

      System.out.println(totalFruit(new int[]{0,1,2,2})); // 3
      System.out.println(totalFruit(new int[]{1,2,1})); // 3
      System.out.println(totalFruit(new int[]{1,2,3,2,2})); // 4
      System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4})); // 5
      System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3})); // 5
   }

}
