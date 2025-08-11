package recursion.medium;
import java.util.*;

public class CombinationSum3 {
   public static List<List<Integer>> combinationSum3(int k, int n) {

      List<List<Integer>> ans = new ArrayList<>();
      helper1(k , n , 1, new ArrayList<>(), ans);
      return ans;
   }

   private static void helper1(int k, int tar , int idx ,ArrayList<Integer> ds , List<List<Integer>> ans){

      //base cases.
      if(tar == 0){
         if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
         }
         return;
      }


      //recursive calls.
      for(int i = idx ; i <= 9; i++){

//         if(i > idx && arr[i] == arr[i-1]) continue;
         if(i > tar) break;

         ds.add(i);
         helper1(k , tar-i , i + 1 , ds, ans);
         ds.removeLast();
      }
   }

   public static void main(String[] args) {
      System.out.println(combinationSum3(3 , 7));
      System.out.println(combinationSum3(3 , 9));
   }
}
