package Leetcode;

//2563:
//Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
//    A pair (i, j) is fair if:
//    0 <= i < j < n, and
//lower <= nums[i] + nums[j] <= upper

public class CountFairPairs {
   public static void main(String[] args) {
      System.out.println(countFairPairs(new int[]{0,1,7,4,4,5}, 3 , 6));
//      outerloop:
//         for(int i = 0; i < 4; i++){
//            innerloop:
//               for(int j = i+1; j < 5; j++){
//                  if(j > 2) {
//                     continue outerloop;
//                  };
//                  System.out.print(j+" ");
//               }
//            System.out.println();
//         }
   }

   public static long countFairPairs(int[] nums, int lower, int upper) {
      long count = 0;
      int n = nums.length;
      for(int i = 0; i < n-1; i++){
         for(int j = i+1; j < n ; j++){
            long sum = nums[i]+nums[j];
            if(sum >= lower && sum <= upper){
               count++;
            }
         }
      }
      return count;
   }
}
