package Arrays.Easy;

import java.util.HashMap;

public class LongestSubArrayWithSumK {

   public static void main(String[] args) {
      int[] arr = {10,5 , 2, 7 , 1, -10};
      System.out.println(longestSubarray(arr , 15));
   }
   public static int longestSubarray(int[] arr, int k) {

      //prefix sum method.
      int maxLen = 0;
      int n = arr.length;
      long sum = 0;
      HashMap<Long , Integer> prefixSumMap = new HashMap<>();
      for(int i = 0; i < n ;i++){
         sum += arr[i];
         if(sum == k){
            maxLen = Math.max(maxLen , i+1);
         }
         if(prefixSumMap.containsKey(sum -k)){
            maxLen = Math.max(maxLen , (i-prefixSumMap.get(sum-k)));
         } else{
            if(!prefixSumMap.containsKey(sum)){
               prefixSumMap.put(sum , i);
            }
         }
      }
      return maxLen;
   }
}
