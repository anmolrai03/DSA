package binarysearch.sectionC;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxOnesinTwoD {
   public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
      int maxCount = Integer.MIN_VALUE;
      int ansIdx = 0;
      for(int i = 0; i < n ; i++){
         int onesCnt = 0;
         ArrayList<Integer> list = new ArrayList<>();
         list = mat.get(i);
         for(int num: list){
            if(num == 1){
               onesCnt++;
            }
         }
         if(maxCount < onesCnt){
            maxCount = onesCnt;
            ansIdx = i;
         }
      }
      return ansIdx;
   }
   public static void main(String[] args) {

      ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,1,1));
      ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0,0,0));
      ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(0,0,0));

      ArrayList<ArrayList<Integer>> matix = new ArrayList<>(Arrays.asList(list1, list2,list3));
      System.out.println(matix);

      System.out.println(rowMaxOnes(matix , 3 , 3));

   }
}
