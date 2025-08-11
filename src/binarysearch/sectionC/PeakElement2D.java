package binarysearch.sectionC;

public class PeakElement2D {
   public int[] findPeakGrid(int[][] mat) {
      int rowsize = mat.length;
      for(int i = 0 ; i < rowsize; i++){
         int colsize = mat[i].length;
         for(int j = 0 ; j < colsize; i++){
            if(peakEle(mat , i , j)){
               return new int[]{i , j};
            }
         }
      }
      return new int[]{-1,-1};
   }

   static boolean peakEle(int[][] mat , int row , int col){
      int rowSize = mat.length;
      int colSize = mat[row].length;
//      if(col-1 >0 && ){
//
//      }
      return true;
   }
}
