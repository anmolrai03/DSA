package recursion.medium;

import java.util.*;

public class SubsetTwo {

   //Brute Force
   public static List<List<Integer>> subsetsWithDup1(int[] nums) {
      Set<List<Integer>> st = new HashSet<>();
      st = helper(new ArrayList<>() , nums, 0);
      List<List<Integer>> list = convertToList(st);
      list.sort(Comparator.comparingInt(List::size));
      list.sort(Comparator.comparingInt(row -> row.get(0)));
      list.addFirst(new ArrayList<>());
      return list;
   }

   private static List<List<Integer>> convertToList(Set<List<Integer>> st) {
      List<List<Integer>> ans = new ArrayList<>();
      for(List<Integer> li: st){
         ans.add(li);
      }
      return ans;
   }

   private static Set<List<Integer>> helper(ArrayList<Integer> p , int[] up , int i){
      if(i == up.length){
         Set<List<Integer>> st = new HashSet<>();
         if(p.isEmpty()){
            return st;
         }
         st.add(new ArrayList<>(p));
         return st;
      }

      p.add(up[i]);
      Set<List<Integer>> pick = helper(p , up , i+1);
      p.removeLast();

      Set<List<Integer>> notPick = helper(p , up , i+1);

      pick.addAll(notPick);
      return pick;
   }


   // trying backtracking with recursion
   public static List<List<Integer>> subsetsWithDup(int[] nums){
      Arrays.sort(nums);
      List<List<Integer>> ans = new ArrayList<>();

      backtrack(nums, 0 , new ArrayList<>() , ans);

      return ans;
   }

   private static void backtrack(int[] nums , int idx , List<Integer> p ,
                                                List<List<Integer>> result){

      result.add(new ArrayList<>(p));

      for(int i = idx; i < nums.length; i++){
         if( i > idx && nums[i] == nums[i-1]) continue;

         p.add(nums[i]);
         backtrack(nums, i + 1, p , result);
         p.removeLast();
      }
   }

   private static List<List<Integer>> helperBack(List<Integer> p , int[] up , int i ,
                                                 HashMap<String , Boolean> backtrack){

      // create key.
      String key = p.toString()+"-"+i;
      // do not add answer if call is already present in the backtrack map.
      if(!backtrack.isEmpty() && backtrack.containsKey(key) && !backtrack.get(key)) return new ArrayList<>();

      // base case
      if(i == up.length){
         // save key with value in backtrack

         List<Integer> list = new ArrayList<>(p);
         List<List<Integer>> ans = new ArrayList<>();
         ans.add(list);
         ans.sort(Comparator.comparingInt(List::size));
         ans.sort(Comparator.comparingInt(row -> row.get(0)));

         return ans;
      }

      // recursive case
      // exclude
      List<List<Integer>> ex = helperBack(p , up , i+1, backtrack);

      // include
      p.add(up[i]);
      List<List<Integer>> in = helperBack(p , up , i+1, backtrack);
      p.removeLast();

      // add both side result and send above
      ex.addAll(in);
      backtrack.put(key , false);

      // return statement.
      return ex;

   }

   public static void main(String[] args) {
//      System.out.println(subsetsWithDup(new int[] {1, 2, 2}));
//      List<Integer> p = new ArrayList<>();
//      p.add(2);
//      p.add(3);
//      int i = 3;
//      String key = p.toString()+"-"+i;
//      String comare = "[2, 3]-3";
//      System.out.println(key);
//      System.out.println(key.equals(comare));
      System.out.println(subsetsWithDup(new int[]{1,2,2}));
      System.out.println(subsetsWithDup(new int[]{4,4,4,1,4}));
   }
}
