package assessment;

import java.util.*;


public class MergeArrays{

   public static void main(String args[]){
      //input section starts here
      List<List<Integer>> list = new ArrayList<>();
      List<Integer> in = new ArrayList<>();
      in.add(1);
      in.add(2);
      list.add(new ArrayList<>(in));

      in.clear();
      in.add(4);
      list.add(new ArrayList<>(in));

      in.clear();
      //input ends

      //result array.
      List<Integer> ans = new ArrayList<>();

      //merging it
      for(int i = 0; i< list.size(); i++){
         ans = merge(ans , list.get(i));
      }
      System.out.println(ans);

   }

   //fucntion to merge two sorted arrays.
   static List<Integer> merge(List<Integer> arr1 ,List<Integer> arr2){

      int n = arr1.size();
      int m = arr2.size();

      if(n == 0) return arr2;
      if(m == 0) return arr1;

      List<Integer> res = new ArrayList<>();

      int i =0;
      int j =0;
      // int k =0;
      while(i <n && j < m){
         if(arr1.get(i) < arr2.get(j)){
            res.add(arr1.get(i++));
         } else {
            res.add(arr2.get(j++));
         }
      }

      while(i < n){
         res.add(arr1.get(i++));
      }

      while(j < m){
         res.add(arr2.get(j++));
      }

      return res;
   }
}
