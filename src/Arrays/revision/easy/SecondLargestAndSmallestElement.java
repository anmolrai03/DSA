package Arrays.revision.easy;

import java.util.Arrays;

public class SecondLargestAndSmallestElement {

   static int[] secondLarAndSmall(int[] array){

      if(array.length == 0 || array.length == 1){
         return new int[] {-1, -1};
      }
      int largest = Integer.MIN_VALUE , secondLargest = Integer.MIN_VALUE  , smallest= Integer.MAX_VALUE,
          secondSmallest =
              Integer.MAX_VALUE;

      for(int num : array){
         //largest and smallest logic
         if(num > largest){
            largest = num;
         }
         if(num < smallest){
            smallest = num;
         }
      }

      for(int num : array){
         if(  num != largest && num > secondLargest ){
            secondLargest = num;
         }

         if( num != smallest &&  num < secondSmallest ){
            secondSmallest = num;
         }
      }

      return new int[] {secondLargest , secondSmallest};
   }

   public static void main(String[] args) {
      int[] result = secondLarAndSmall(new int[]{1,2,4 , 7, 7 , 5});
      System.out.println(Arrays.toString(result));
   }

}
