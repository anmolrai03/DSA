package Leetcode;

//March 13: 3356
public class ZeroArrayII {

   //correct but tle
   public static int minZeroArray(int[] nums, int[][] queries) {
      if(zeroArray(nums)){
         return 0;
      }
      int n = nums.length;
      int k = 0;
      for(int[] q: queries){
         for(int i = q[0] ; i<= q[1]; i++){
            if(nums[i] == 0){
               continue;
            }
            if(nums[i] >= q[2]){
               nums[i] -= q[2];
            } else{
               nums[i] = 0; //nums[i] = nums[i] - nums[i] because it is smaller then vali so all
               // can be subtracted to make it zero.
            }
         }
         k++;
         if(zeroArray(nums)){
            return k;
         }
      }
      return -1;
   }

   private static boolean zeroArray(int[] nums) {
      for(int num : nums){
         if(num != 0){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      int[] nums = {2, 0 , 2};
//      int[] nums = {4,3,2,1};
      int[][] queries = {{0,2,1} , {0,2,1}, {1,1,3}};
//      int[][] queries = {{1,3,2} , {0,2,1}};
      System.out.println(minZeroArray(nums , queries));
   }
}
