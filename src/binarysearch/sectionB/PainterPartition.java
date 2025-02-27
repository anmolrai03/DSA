package binarysearch.sectionB;

public class PainterPartition {
   static int findMinTime(int[] board , int painter){
      if(board.length < painter){
         return -1;
      }
      int s = maxEle(board);
      int e = summation(board);
      int ans = Integer.MAX_VALUE;
      while (s <= e){
         int m = s + (e-s)/2;
         int currentPainterCount = 1;
         int boardSum= 0;

         //to get the possible number of painter for a particular time and area selected.
         for(int num: board){
            if(num +boardSum <= m){
               boardSum += num;
            } else {
               currentPainterCount++;
               boardSum = num;
            }
         }

         //checking
         if(currentPainterCount > painter){
            //more painter is required so take more area to work.
            s = m+1;
         }
         else if(currentPainterCount == painter){
            ans = Math.min(ans , m);
            e = m -1;
         } else {
            e = m-1;
         }
      }
      return ans;
   }

   private static int summation(int[] board) {
      int sum = 0;
      for(int num: board){
         sum += num;
      }
      return sum;
   }

   private static int maxEle(int[] board) {
      int max = board[0];
      for(int num: board){
         if(max <num ){
            max = num;
         }
      }
      return max;
   }

   public static void main(String[] args) {
      int[] arr = {5, 5, 5, 5};
      int k = 2;
      System.out.println(findMinTime(arr , k));
      System.out.println(findMinTime(new int[] {10, 20, 30, 40} , 2));
   }
}
