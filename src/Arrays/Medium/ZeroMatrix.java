package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroMatrix {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {

        // SELF
    	// Write your code here.
        /*
        ArrayList<ArrayList<Integer>> location = new ArrayList<>();
        for(int i = 0; i< n;i++){
            
            for(int j = 0; j< m; j++){
                ArrayList<Integer> row = new ArrayList<>();
                if(matrix.get(i).get(j) == 0){
                    row.add(i);
                    row.add(j);
                }
                if(!row.isEmpty()){
                    location.add(row);
                }
            }
        }
        System.out.println(location);
        //Setting to zero.
        for(int i = 0; i < location.size(); i++){
            // System.out.println(location.get(i).get(0)+" "+ location.get(i).get(1));
            settingZero(matrix, location.get(i).get(0), location.get(i).get(1));
        }
        return matrix;
         */

        
        // BRUTE FORCE

        return matrix;
    }
    /*
    private static void settingZero(ArrayList<ArrayList<Integer>> matrix, Integer row, Integer col){
        //row set to zero.
        for(int k = 0; k < matrix.get(row).size(); k++){
            matrix.get(row).set(k, 0);
        }
        //column set to zero.
        for(int l = 0; l < matrix.size(); l++){
            matrix.get(l).set(col,0);
        }
    }

    */

    public static void setZeroes(int[][] matrix) {
        /* BRUTE FORCE
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix,i);
                    markCol(matrix,j);
                }
            }
        }
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = 0;
                }
            }
        }
        */

        // BETTER 
        // Time Complexity : O(m*n) + O(m*n)
        //Space Complexity: O(m) + O(n)
        /*
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        // Marking row and column of the matrix with 0 as value.
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        //Setting zero
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
        */

    }

    private static void markRow(int[][] matrix, int row){
        for(int k = 0; k < matrix[row].length; k++){
            if(matrix[row][k] != 0){
                matrix[row][k] = -1;
            }
            
        }
    }


    private static void markCol(int[][] matirx, int col){
        for(int k = 0; k < matirx.length; k++){
            if(matirx[k][col] != 0){
                matirx[k][col] = -1;
            }
        }
    }

    public static void main(String[] args) {
        // ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        // ArrayList<Integer> row1 = new ArrayList<>(Arrays.asList(6,5,1,6,8));
        // row1.add(5);
        // row1.add(4);
        // row1.add(3);
        // ArrayList<Integer> row2 = new ArrayList<>(Arrays.asList(2, 8, 0, 7, 5));
        // ArrayList<Integer> row3 = new ArrayList<>(Arrays.asList(4, 4, 0, 6, 2  ));
        // ArrayList<Integer> row4 = new ArrayList<>(Arrays.asList(9, 6 ,3, 7, 5));
        // row2.add(1);
        // row2.add(0);
        // row2.add(0);
        // matrix.add(row1);
        // matrix.add(row2);
        // matrix.add(row3);
        // matrix.add(row4);
        // matrix.add(row2);
        // System.out.println(row1);
        // System.out.println(row2);
        // System.out.println(matrix);
        // System.out.println(row1.size());
        // System.out.println(row2.size());
        // System.out.println(matrix.get(1).get(0));
        // System.out.println(matrix);
        // System.out.println(zeroMatrix(matrix,matrix.size(),5));

        int[][] arr = {{6,5,1,6,8},{2,8,0,7,5},{4,4,0,6,2},{9,6,3,7,5}};
        for(int[] a: arr){
            for(int i: a){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        setZeroes(arr);

        System.out.println("\n");
        for(int[] a: arr){
            for(int i: a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
