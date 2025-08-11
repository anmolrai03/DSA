package recursion.medium;

//You are given an array 'nums' of ‘n’ integers.
//Return all subset sums of 'nums' in a non-decreasing order.

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSumI {
   public static ArrayList<Integer> subsetSum(int num[]) {
      // Write your code here..
      ArrayList<Integer> ans = helper(num , 0, 0);
      Collections.sort(ans);
      return ans;
   }

   private static ArrayList<Integer> helper(int[] up, int idx,int sum){
      //base condition.
      if(idx == up.length){
         ArrayList<Integer> li = new ArrayList<>();
         li.add(sum);
         return li;
      }

      //picking the number.
      sum += up[idx];
      ArrayList<Integer> pick = helper(up , idx + 1, sum);
      sum -= up[idx];

      //not picking the number.
      ArrayList<Integer> notPick = helper(up , idx + 1 , sum);
      pick.addAll(notPick);
      return pick;
   }

   public static void main(String[] args) {
      System.out.println(subsetSum(new int[] {1, 2, 3}));
      System.out.println(subsetSum(new int[] {0, 4, 5 ,9}));
   }
}
