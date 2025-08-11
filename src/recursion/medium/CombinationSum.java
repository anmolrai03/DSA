package recursion.medium;

import java.util.ArrayList;
import java.util.List;

//find all combination to get a certain sum with target. repetation allowed.

public class CombinationSum {
   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<Integer> p = new ArrayList<>();
      return helper(candidates , target , p , 0);
   }

   private static List<List<Integer>> helper(int[] candidates , int target , List<Integer> p ,
                                             int i){

      //base condition.
      if(target < 0){
         List<List<Integer>> list = new ArrayList<>();
         return list;
      }
      if(target == 0){
         List<List<Integer>> list = new ArrayList<>();
         list.add(new ArrayList<>(p));
         return list;
      }

      if(i == candidates.length){
         List<List<Integer>> list = new ArrayList<>();
         return list;
      }

      //pick with same idx and not pick.
      p.add(candidates[i]);
      List<List<Integer>> pick = helper(candidates , target-candidates[i] , p, i);
      p.removeLast();

      List<List<Integer>> notPick = helper(candidates , target , p , i+1);
      pick.addAll(notPick);
      return pick;

   }

   public static void main(String[] args) {
      int[] candidates = {2,3,6,7};
      int target = 7;

      System.out.println(combinationSum(candidates , target));
   }
}
