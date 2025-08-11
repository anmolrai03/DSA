package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition {
   public static void main(String[] args) {
      String s = "aab";
      System.out.println(partition(s));
   }

   public static List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
      helper(s, 0 , new ArrayList<String>() , ans);
      return ans;
   }

   private static List<List<String>> helper(String up, int idx , List<String> p ,
                                            List<List<String>> ans){

      //base case.
      if(idx == up.length()){
         ans.add(new ArrayList<>(p));
         return ans;
      }
      //recursive case.
      for(int i = idx ; i < up.length(); i++){

         String toadd = up.substring(0 , idx+1);
         p.add(toadd);
         helper(up , idx + 1 , p , ans);
         p.removeLast();
      }
      return ans;
   }
}
