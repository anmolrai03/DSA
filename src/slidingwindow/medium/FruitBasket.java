package slidingwindow.medium;

//Given an array arr[] containing positive elements, the task is to find the length of the longest subarray of an input array containing at most two distinct integers.

import java.util.HashMap;

public class FruitBasket {
   public static int totalElements(Integer[] arr) {
      // code here
      int n = arr.length;
      if(n == 0 ) return 0;

      int l = 0; int r = 0;int maxLen = 0;
      HashMap<Integer , Integer> map = new HashMap<>();

      while(r < n){
         map.put(arr[r] , map.getOrDefault(arr[r] , 0)+1);
         while(map.size() > 2){
            if(map.get(arr[l]) == 1){
               map.remove(arr[l]);
            } else{
               map.replace(arr[l] , map.get(arr[l])-1);
            }
            l++;
         }
         maxLen = Math.max(maxLen , (r-l)+1);
         r++;
      }
      return maxLen;
   }

   public static void main(String[] args) {
//      Integer[] arr = {3,1,2,2,2,2};
//      Integer[] arr = {2, 2, 2, 2, 3 ,4 ,4 ,4};
//      Integer[] arr = {5, 4, 5, 1, 1 ,1 ,6};
//      Integer[] arr = {5, 5, 5, 5, 5 ,5 ,5};
//      Integer[] arr = {5};
      Integer[] arr = {};
//      Integer[] arr = {2,1,2};
      System.out.println(totalElements(arr));
//      HashMap<Integer , Integer> frq = new HashMap<>();
//      for(int num: arr){
//         frq.put(num , frq.getOrDefault(num , 0)+1);
//      }
//      System.out.println(frq);
   }

}
