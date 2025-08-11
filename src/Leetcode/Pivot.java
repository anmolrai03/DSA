package Leetcode;

import java.util.Arrays;

public class Pivot {

   static void sort(int[] nums, int pivot) {

      int s = 0;
      int e = nums.length-1;
      if (s >= e) {
         return;
      }

      while (s <= e) {

         // also a reason why if its already sorted it will not swap
         while (nums[s] < pivot) {

            s++;
         }
         while (nums[e] > pivot) {
            e--;
         }

         if (s <= e) {

            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
         }
      }

      // now my pivot is at correct index, please sort two halves now
//      sort(nums, low, e);
//      sort(nums, s, hi);
   }

   public static void main(String[] args) {
      int[] arr = {9, 12, 5, 10 , 14, 3, 10};
      sort(arr, 10);
      System.out.println(Arrays.toString(arr));
   }
}
