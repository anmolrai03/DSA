package Sept.CoreRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//78
public class SubsetsPattern {
   public static List<List<Integer>> subsetUnique(int[] nums){
      Arrays.sort(nums);
      List<List<Integer>> res = new ArrayList<>();
      method2(nums , new ArrayList<>() , 0 , res);
      System.out.println(res);
      return helper(nums , new ArrayList<>(), 0);
   }

   // pick - notpick clear type
   private static List<List<Integer>> helper(int[] up , List<Integer> p, int idx ){

      // base case
      if( idx == up.length){
         List<Integer> list = new ArrayList<>(p);
         List<List<Integer>> res = new ArrayList<>();
         res.add(list);
         return res;
      }

      // recursive case
      p.add(up[idx]);
      List<List<Integer>> include = helper(up , p , idx+1);
      p.removeLast();

      List<List<Integer>> exclude = helper(up , p , idx+1);

      exclude.addAll(include);

      return exclude;
   }

   // it is also pick not pick but it backtracks and is more efficent can hanlde duplicates like
   // if(i > idx && nums[i] == num[i-1]) continue; helps to remove duplicate issues.

   private static void method2(int[] up , List<Integer> p , int idx, List<List<Integer>> ans){
      // base case
      ans.add(new ArrayList<>(p));

      // recursive case
      for(int i = idx ; i < up.length; i++){
         p.add(up[i]);
         method2(up , p , i+1, ans);
         p.removeLast();
      }
   }


   public static void main(String[] args) {
      System.out.println(subsetUnique(new int[]{1, 2, 3} ));
   }
}
