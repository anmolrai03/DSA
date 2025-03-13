package Leetcode;

import java.util.Arrays;

//March 1.
public class ApplyOperation {

   private static void swap(int[] arr, int s , int e){
      int temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
   }
   private static void shiftZerosToLast(int[] arr){
      int i = 0;
      int n = arr.length;
      while(i < n){
         int j = i + 1;
         if(arr[i] == 0){
            while( j<n && arr[j] == 0){
               j++;
               if(j >= n){
                  return;
               }
            }
            if(j < n){

               swap(arr , i , j);
            }
         }
         i++;
      }
   }

   public static int[] applyOperations(int[] nums) {
      int n = nums.length;
      if(n == 0){
         return nums;
      }
      if(n == 1){
         return nums;
      }

      for(int i = 0 ; i < n-1; i++){
         if( nums[i] == nums[i+1]){
            nums[i] *= 2;
            nums[i+1] = 0;
         }
      }
      shiftZerosToLast(nums);
      return nums;
   }

   public static void main(String[] args) {
//      int[] arr = {1,2,2,1,1,0};
//      System.out.println(Arrays.toString(applyOperations(arr)));
      int[] ar = {0,1};
      shiftZerosToLast(ar);
      System.out.println(Arrays.toString(ar));
   }

}
