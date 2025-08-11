package Leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//Question 1007:
public class RotateDomino {
   public static int minDominoRotations(int[] tops, int[] bottoms) {

      int[] topData = getMaxEleAndFreq(tops);
      int maxEleT = topData[0];
      int freqT = topData[1];

      int[] bottomData = getMaxEleAndFreq(bottoms);
      int maxEleB = bottomData[0];
      int freqB = bottomData[1];

      int minSwapCnt = 0;
      if(maxEleB == maxEleT){
         if(freqT > freqB){
            minSwapCnt =  minSwap(tops, bottoms, maxEleT);
         } else{
            minSwapCnt = minSwap(bottoms , tops , maxEleB);
         }
      } else{
         if(maxEleT > maxEleB){
            minSwapCnt = minSwap(tops , bottoms , maxEleT);
         } else{
            minSwapCnt = minSwap(bottoms , tops , maxEleB);
         }

      }
      return minSwapCnt;
   }

   private static int minSwap(int[] tops , int[] bottoms, int ele){
      int n = tops.length;
      int swapCnt = 0;
      for(int i = 0; i<n; i++){
         if(tops[i] == ele){
            continue;
         } else if(bottoms[i] == ele){
            swapCnt++;
         } else{
            return -1;
         }
      }
      return swapCnt;
   }

   private static int[] getMaxEleAndFreq(int[] arr){
      HashMap<Integer , Integer> map = new HashMap<>();
      for(int num: arr){
         map.put(num , map.getOrDefault(num , 0)+1);
      }

      int maxEle = Integer.MIN_VALUE;
      int freqOfMax = 0;
      for(Map.Entry<Integer , Integer> entry: map.entrySet()){
         if(entry.getValue() > freqOfMax){
            freqOfMax = entry.getValue();
            maxEle = entry.getKey();
         }
      }
      return new int[]{maxEle , freqOfMax};
   }


   //main class
   public static void main(String[] args) {
      System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2} , new int[]{5,2,6,2,3,2}));
      System.out.println(minDominoRotations(new int[]{3,5,1,2,3} , new int[]{3,6,3,3,4}));
      System.out.println(minDominoRotations(new int[]{} , new int[]{}));

   }

}
