package recursion.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SubsetSum2 {
   public static void main(String[] args) {
      List<List<Integer>> list = new ArrayList<>();


      list.add(new ArrayList<>(Arrays.asList(3, 4, 5)));
      list.add(new ArrayList<>(Arrays.asList(5, 8, 5)));
      list.add(new ArrayList<>(Arrays.asList(1, 4, 10)));
      list.add(new ArrayList<>(Arrays.asList(2, 1, 5)));

      System.out.println(list);
      list.sort(Comparator.comparingInt(row -> row.getFirst()));
      System.out.println(list);

      List<List<Integer>> ans = subsetsWithDup(new int[]{1, 2, 2});
//      ans.sort(Comparator.comparingInt(row -> row.get(0)));

      System.out.println(ans);

   }

   public static List<List<Integer>> subsetsWithDup(int[] nums) {
      ArrayList<Integer> p = new ArrayList<>();
      List<List<Integer>> ans =  helper(p , nums);
      ans.sort(Comparator.comparingInt(row -> row.get(0)));

      return ans;
   }

   private static List<List<Integer>> helper(ArrayList<Integer> p , int[] up){
      if(up.length == 0){
         List<List<Integer>> list = new ArrayList<>();
         if(p.isEmpty()){
            return list;
         }
         list.add(new ArrayList<>(p));
         return list;
      }

      //include.
      p.add(up[0]);
      List<List<Integer>> in = helper(p , Arrays.copyOfRange(up , 1 , up.length));
      p.remove(p.size() -1);

      //exclude.
      List<List<Integer>> ex = helper(p , Arrays.copyOfRange(up , 1 , up.length));
      in.addAll(ex);
      return in;
   }
}
