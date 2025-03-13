package slidingwindow.medium;

import java.util.Scanner;

public class ConsecutiveOnesIII {
   public static int longestOnes(int[] nums, int k) {
      int maxLen = Integer.MIN_VALUE;
      int n = nums.length; int l = 0; int r = 0; int tempK = 0;

      while( r < n){
         if(nums[r] == 1){
            maxLen= Math.max(maxLen , (r-l) + 1);
            r += 1;
         }
         else {

            if(tempK < k){
               tempK++;
               maxLen = Math.max(maxLen , (r-l) + 1);
               r += 1;
            }
            else{
               while(tempK >= k){
                  if(nums[l] == 0){
                     tempK--;
                  }
                  l++;
               }
            }
         }
      }
      return maxLen;
   }

   public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      String s= sc.next();
//      int k = sc.nextInt();
//      char[] nums = s.toCharArray();
      int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
//      int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
      System.out.println(longestOnes(nums , 2));

   }
}
