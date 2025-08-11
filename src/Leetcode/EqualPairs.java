package Leetcode;

//2176. Count Equal and Divisible Pairs in an Array

import java.util.HashMap;

public class EqualPairs {

   public static int countPairs(int[] nums, int k) {

      int n = nums.length;
      if(n == 0) return 0;

      //BRUTE FORCE.
      int count = 0;
      for(int i = 0; i < n-1; i++){
         for(int j = i+1; j < n; j++){
            if(nums[i] == nums[j] && (i * j)%k == 0){
               count++;
            }
         }
      }
      return count;

//      HashMap<Integer, Integer> map = new HashMap<>();
//      int count = 0;
//      for(int i = 0; i < n ;i++){
//
//         int val = map.get(nums[i]);
//
//         if(map.containsKey(nums[i])){
//            //check if possible.
//            if(i > val){
//               if(i*val % k == 0){
//                  count++;
//               }
//            }
//         } else{
//            map.put(nums[i] , 0);
//         }
//      }
//      return 0;
   }
}
