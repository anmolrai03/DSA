package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class MissingRepetedTwoD {
   public static int[] findMissingAndRepeatedValues(int[][] grid) {
      int[] ans = {-1,-1};
      int repeatedNum = -1;

      //total sum and frequency store in hashmap.
      HashMap<Integer , Integer> map = new HashMap<>();
      int totalSum = 0;
      for(int[] num: grid){
         for(int val : num){
            totalSum += val;
            if(map.containsKey(val)){
               repeatedNum=val;
            } else{
               map.put(val , 1);
            }
         }
      }


      int missing = requiredSum(grid) - (totalSum - repeatedNum);
      ans[0] = repeatedNum;
      ans[1] = missing;
      return ans;
   }

   private static int totalSum(int[][] grid) {
      HashMap<Integer , Integer> map = new HashMap<>();
      int sum = 0;
      for(int[] num: grid){
         for(int val : num){
            sum += val;
            if(map.containsKey(val)){
              map.put(val , map.get(val)+ 1);
            } else{
               map.put(val , 1);
            }
         }
      }
      return sum;
   }

   private static int requiredSum(int[][] grid) {
      int n = grid.length;
      int lastNum = (int) Math.pow(n , 2);
      int requiredSum =( lastNum * (lastNum + 1))/2;
      return requiredSum;
   }

   private static int findRepeated(int[][] grid) {
      return 0;
   }

   public static void main(String[] args) {
      int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
      System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
   }
}
