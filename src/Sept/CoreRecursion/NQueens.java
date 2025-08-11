package Sept.CoreRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51
public class NQueens {

   public static List<List<String>> solveNQueens(int n) {
      boolean[][] board = new boolean[n][n];

      for(boolean[] b: board){
         Arrays.fill(b, true);
      }

      List<List<String>> res = new ArrayList<>();
      getCombos(board , 0, n, res , new ArrayList<>());
      return res;
   }

   private static void getCombos(boolean[][] board , int row ,  int n ,
                                 List<List<String>> ans,
                                 List<String > p){

      // base case.
      if( row == n){
         ans.add(new ArrayList<>(p));
         return;
      }

      // recursive logic
      StringBuilder sb = new StringBuilder();

      for(int col = 0; col < n; col++){

         if(!board[row][col]){
            sb.append(".");
            continue;
         }

         sb.append("Q");

         // fill board with false;
         fillBoard(board , false , row , col , n);
         for(boolean[] b: board){
            System.out.println(Arrays.toString(b));
         }

         // call function for next row
         getCombos(board ,row+1 ,n, ans , p );

         // backtrack
         fillBoard(board, true , row , col , n);
         for(boolean[] b: board){
            System.out.println(Arrays.toString(b));
         }

         sb.replace(sb.length()-1 , sb.length() , ".");

      }

//      p.add(sb.toString());

   }

   private static void fillBoard(boolean[][] board , boolean value, int row , int col , int n){
      // keep the corresponding row to false
      for(int c = col; c < n; c++){
         board[row][c] = value;
      }

      // corresponding column to false
      for(int r = row; r < n; r++ ){
         board[r][col] = value;
      }

      // diagonal elements
      int i = row;
      int j = col;

      //top left board[i-1][j-1]
      while(i >= row && j >= col){
         board[i--][j--] = value;
      }

      // top right board[i-1][j+1];
      i = row;
      j = col;
      while(i >= row && j < n){
         board[i--][j++] = value;
      }

      // bottom right board[i+1][j+1]
      i = row;
      j = col;
      while(i < n && j < n){
         board[i++][j++] = value;
      }

      // bottom left board[i+1][j-1]
      i = row;
      j = col;
      while(i < n && j >= col){
         board[i++][j--] = value;
      }
   }



   public static void main(String[] args) {
//      int n = 4;
//      boolean[][] board = new boolean[n][n];
//
//      for(boolean[] b: board){
//         Arrays.fill(b, true);
//      }
//
//      for(boolean[] b: board){
//         System.out.println(Arrays.toString(b));
//      }
      System.out.println(solveNQueens(4));

   }
}
