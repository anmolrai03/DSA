package binarysearch.sectionB;

import java.util.ArrayList;
import java.util.Collections;

public class BookAllocatioin {

   public static int findPages(ArrayList<Integer> arr, int n, int m) {
      // Write your code here.
      int s = maxEle(arr);
      System.out.println(s);

      int e = summation(arr);
      System.out.println(e);

      int ans = Integer.MAX_VALUE;
      while (s <= e){
         int mid = s + (e-s)/2;
         int pagesSum = 0;
         int stdCnt = 1;
         for(int page: arr){
            if(pagesSum + page <= mid){
               pagesSum += page;
            } else {
               stdCnt++;
               pagesSum = page;
            }
         }

         if(stdCnt <= m){
            e = mid-1;
            ans = Math.min(ans , mid);
         }
         // else if(stdCnt == m){

         //     e = mid -1;
         // }
         else{
            s = mid + 1;
         }
      }
      return ans;
   }

   private static int maxEle(ArrayList<Integer> list){
      int max = list.get(0);
      for(int num: list){
         if(num > max){
            max = num;
         }
      }
      return max;
//      Collections.sort(list);
//      return list.get(list.size()-1);
   }

   private static int summation(ArrayList<Integer> list){
      int sum = 0;
      for(int num: list){
         sum += num;
      }
      return sum;
   }

   public static void main(String[] args) {
      ArrayList<Integer> list = new ArrayList<>();
      list.add(25);
      list.add(46);
      list.add(28);
      list.add(49);
      list.add(24);

      System.out.println(findPages(list , list.size() , 4));
   }
}
