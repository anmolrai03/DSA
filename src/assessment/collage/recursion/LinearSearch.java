package assessment.collage.recursion;

import java.util.ArrayList;

public class LinearSearch {
   public static void main(String[] args) {
      int[] arr = {78 , 3 , 298 , 8, 8};
      int target = 8;
      ArrayList<Integer> list = new ArrayList<>();
      System.out.println(linearSearch(arr , target , 0));
      System.out.println(findIdx(arr , target , 0));
      System.out.println(findAll(arr , target , 0 , list));
   }


   static boolean linearSearch(int[] arr , int target , int idx){

      //base condition.
      if(idx == arr.length){
         return false;
      }

      return arr[idx] == target || linearSearch(arr , target , idx + 1);
   }

   static int findIdx(int [] arr , int target , int idx){
      //base condition.
      if(idx == arr.length){
         return -1;
      }

      //recursive condition.
      if(arr[idx] == target){
         return idx;
      }
      return findIdx(arr , target , idx + 1);
   }

   static ArrayList<Integer> findAll(int[] arr , int target , int idx , ArrayList<Integer> list){
      //base condition.
      if(idx == arr.length){
         return list;
      }

      if(arr[idx] == target){
         list.add(idx);
      }
      return findAll(arr , target, idx + 1 , list);
   }


}
