package Sept.CoreRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 46
public class Permutations {
   public static List<List<Integer>> permute(int[] nums){
      List<List<Integer>> res = new ArrayList<>();

      Arrays.sort(nums); // in case you need to find only unique ones and no repeated.
      getPermutations(nums , 0, res);
      return res;
   }


   private static void getPermutations(int[] nums , int idx , List<List<Integer>> ans){
      // base case
      if(idx == nums.length){
         List<Integer> perm = new ArrayList<>();
         for(int num: nums) perm.add(num);
         ans.add(perm);
         return;
      }
      //recursive case
//      HashSet<Integer> set = new HashSet<>();
//
//      for(int i = idx ; i < nums.length; i++){
//         if(set.contains(nums[i])) continue;
//         set.add(nums[i]);
      for(int i = idx ; i < nums.length; i++){
         if(i > idx && nums[i] == nums[i-1]) continue; // to prevent from making duplicates .
         swap(nums, idx, i); // changing position of elements
         getPermutations(nums , idx + 1, ans);
         swap(nums, idx , i); // backtrack
      }
   }



   private static void swap(int[] nums, int i , int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }


   private static void helper(int[] up , List<Integer> p , int idx , List<List<Integer>> ans){
      // base case
      if(p.size() == up.length){
         ans.add(new ArrayList<>(p));
      }
      // recursive case
      for(int i = 0; i < up.length; i++){
         if(i == idx) continue;

         p.add(up[i]);
         helper(up , p , idx+1 , ans);
         p.removeLast();
      }
   }

   public static void main(String[] args) {
      System.out.println(permute(new int[] {1, 2, 3}));
      System.out.println(permute(new int[] {1, 1, 2}));
      System.out.println(permute(new int[] {0,1,0,0,9}).size());

      List<List<Integer>> list = Arrays.asList(
          Arrays.asList(0, 0, 0, 1, 9),
          Arrays.asList(0, 0, 0, 9, 1),
          Arrays.asList(0, 0, 1, 0, 9),
          Arrays.asList(0, 0, 1, 9, 0),
          Arrays.asList(0, 0, 9, 0, 1),
          Arrays.asList(0, 0, 9, 1, 0),
          Arrays.asList(0, 1, 0, 0, 9),
          Arrays.asList(0, 1, 0, 9, 0),
          Arrays.asList(0, 1, 9, 0, 0),
          Arrays.asList(0, 9, 0, 0, 1),
          Arrays.asList(0, 9, 0, 1, 0),
          Arrays.asList(0, 9, 1, 0, 0),
          Arrays.asList(1, 0, 0, 0, 9),
          Arrays.asList(1, 0, 0, 9, 0),
          Arrays.asList(1, 0, 9, 0, 0),
          Arrays.asList(1, 9, 0, 0, 0),
          Arrays.asList(9, 0, 0, 0, 1),
          Arrays.asList(9, 0, 0, 1, 0),
          Arrays.asList(9, 0, 1, 0, 0),
          Arrays.asList(9, 1, 0, 0, 0)
      );

      System.out.println(list.size());
   }
}
