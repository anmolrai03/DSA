package recursion.medium;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//Each number in candidates may only be used once in the combination.
//Note: The solution set must not contain duplicate combinations.
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output:
//    [
//    [1,1,6],
//    [1,2,5],
//    [1,7],
//    [2,6]
//    ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
   public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

      ArrayList<Integer> ds = new ArrayList<>();
//      return helper(candidates , target , 0, ds);
      Arrays.sort(candidates);
      List<List<Integer>> ans = new ArrayList<>();
      helper1(candidates , target , 0, ds, ans);
      return ans;
   }

   private static List<List<Integer>> helper(int[] arr , int tar , int idx , ArrayList<Integer> ds){
      //base conditon.

      //do not check when target is less than zero as it would futher keep on decreasing , so no
      // need to for extra recusrive calls.
      if(tar < 0){
         List<List<Integer>> list = new ArrayList<>();
         return list;
      }

      //stop and return the ans when the target is zero , i.e, a combination of required target
      // has been found.
      if(tar == 0){
         List<List<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>(ds));
         return list;
      }

      //if index of the element == length of array recursion needs to stop.
      if(idx == arr.length){
         List<List<Integer>> list = new ArrayList<>();
         return list;
      }

      //recusive cases.
      if(arr[idx] >= 0){

         //pick.
         int temp = arr[idx];
         arr[idx] = -1;

         ds.add(temp);
         List<List<Integer>> pick = helper(arr , tar-temp ,idx +1 ,  ds);
         ds.removeLast();
         arr[idx] = temp;

         //not pick
         List<List<Integer>> notPick = helper(arr, tar, idx + 1 , ds);

         pick.addAll(notPick);
         return pick;
      }

      return helper(arr , tar, idx+1 , ds);

   }

   private static void helper1(int[] arr , int tar , int idx ,
                                              ArrayList<Integer> ds , List<List<Integer>> ans){

      //base cases.
      if(tar == 0){
         ans.add(new ArrayList<>(ds));
         return;
      }

      if(idx == arr.length){
         return;
      }

      //recursive calls.
      for(int i = idx ; i < arr.length; i++){

         if(i > idx && arr[i] == arr[i-1]) continue;
         if(arr[i] > tar) break;

         ds.add(arr[i]);
         helper1(arr , tar-arr[i] , i + 1 , ds, ans);
         ds.removeLast();
      }
   }

   public static void main(String[] args) {
      System.out.println(combinationSum2(new int[]{2,5,2,1,2} , 5));
      System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5} , 8));
   }
}
