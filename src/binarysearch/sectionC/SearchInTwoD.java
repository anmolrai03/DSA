package binarysearch.sectionC;

public class SearchInTwoD {

   static boolean binarySearch(int[] arr , int s , int e , int target){
      while(s <= e) {
         int m = s + (e - s) / 2;
         if (arr[m] == target) {
            return true;
         } else if (arr[m] > target) {
            e = m - 1;
         } else {
            s = m + 1;
         }
      }
      return false;
   }

   public static boolean searchMatrix(int[][] matrix, int target) {

      int row = matrix.length;

      for(int i = 0 ; i < row; i++){
         int col = matrix[i].length;
         if(matrix[i][0] <= target || matrix[i][col-1] >= target){
            return binarySearch(matrix[i] , 0,col-1 , target);
         }
      }
      return false;
   }

   public static void main(String[] args) {
//      int[][] matrix = {{1,3,5,7} , {10,11,16,20} , {23,30,34,60} };
      int[][] matrix = {{1,3} };
      System.out.println(searchMatrix(matrix,3));
   }
}
