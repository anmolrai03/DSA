package Leetcode.contest.contest2;

import java.util.HashMap;

public class CalculateScore {
   public static long calculateScore(String[] instructions, int[] values) {

      int i = 0;
      int n = instructions.length;
      if(n == 0) return 0;
      int score = 0;
      HashMap<Integer, Character> map = new HashMap<>();

      while(i >= 0 && i <= n){

         if(map.containsKey(i)){
            break;
         } else{
            if(i < 0 || i >= n) break;
            map.put(i , instructions[i].charAt(0));
         }

         int val = performOperation(instructions , values , i , instructions[i]);

         if(instructions[i] == "jump"){
            i = val;
         } else{
            score += val;
            i = i+1;
         }
      }
      return score;

   }

   private static int performOperation(String[] instructions , int[] values , int i, String instruct){
      if(instruct == "jump"){
         return i+values[i];
      }
      return values[i];
   }

   public static void main(String[] args) {
      System.out.println(calculateScore(new String[]{"jump","add","add","jump","add","jump"} ,
          new int[]{2,1,3,1,-2,-3}));
      System.out.println(calculateScore(new String[]{"jump","add","add"} ,
          new int[]{3,1,1}));
   }
}
