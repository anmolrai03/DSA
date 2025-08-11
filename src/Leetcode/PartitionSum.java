package Leetcode;

public class PartitionSum {
   public static boolean canPartition(int[] nums) {
      if(nums.length == 0) return false;
      int sum = 0;
      for(int num: nums){
         sum += num;
      }
      if(sum %2 != 0){
         return false;
      }
      return sumExists(nums, sum/2 , 0);
   }

   private static boolean sumExists(int[] arr , int tar, int idx){
      if(tar < 0){
         return false;
      }
      if(tar == 0){
         return true;
      }

      if(idx == arr.length){
         return false;
      }

      if(tar >= arr[idx]){
         //pick or not pick
         return (sumExists(arr , tar-arr[idx] , idx+ 1) || sumExists(arr , tar, idx+1));
      }
      return sumExists(arr , tar , idx + 1);
   }

   public static void main(String[] args) {
//      System.out.println(canPartition(new int[] {1,5,11,5}));
      System.out.println(canPartition(new int[] {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
   }
}
