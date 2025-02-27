package binarysearch.sectionB;

import java.util.Arrays;

public class Median {
   public static double median(int[] a, int[] b) {
      // Write your code here.
      //Add arrays in sorted way.
      int sizeA = a.length;
      int sizeB = b.length;

      int[] mergedArray = new int[sizeA + sizeB];
      int i = 0 , j = 0 , k = 0;
      while(i < sizeA && j < sizeB){
         if(a[i] < b[j]){
            mergedArray[k++] = a[i++];
         } else {
            mergedArray[k++] = b[j++];
         }
      }

      while(i < sizeA){
         mergedArray[k++] = a[i++];
      }
      while ( j < sizeB){
         mergedArray[k++] = b[j++];
      }
//      System.out.println(Arrays.toString(mergedArray));
      //finding median of the sorted arrays.
      double median;
      //also k = size of the merged Array.
//      System.out.println(k);
      if( k % 2 != 0){
         int medianIdx =Math.ceilDiv( k ,2) - 1;
//         System.out.println(medianIdx);
         median = mergedArray[medianIdx];
      } else {
         int firstMedianIdx =( k/2 - 1);
//         System.out.println(firstMedianIdx);

         int secondMedianIdx = k/2;
//         System.out.println(secondMedianIdx);
//         System.out.println(mergedArray[firstMedianIdx] + mergedArray[secondMedianIdx]);
         int sum = mergedArray[firstMedianIdx] + mergedArray[secondMedianIdx];
         median = (double) sum/2;
      }

      return median;
   }

   public static void main(String[] args) {
      int[] a = {2, 4, 6};
      int[] b = {1, 3};
      System.out.println(median(a , b));
   }
}
