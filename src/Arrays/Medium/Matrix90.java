package Arrays.Medium;

public class Matrix90{

    public static void rotate(int[][] matrix) {

        //VALID FOR N*N MATRIX ONLY AND USES extra space.
        //BRUTE FORCE
        /*
        int[][] result = new int[matrix[0].length][matrix.length]; // Initialize the inner arrays
        // for(int i = 0; i < result.length; i++){
        //     Arrays.fill(result[i], 0); // Now you can fill the inner arrays with zeros
        // }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int ele = matrix[i][j];
                result[j][(matrix.length - 1) - i] = ele;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = result[i][j];
            }
        }

        */


        //BETTER.
        /* 
            - Transpose the matrix 
                [0][1] -> [1][0]
                [0][2] -> [2][0]
                [0][3] -> [3][0]

                [1][2] -> [2][1]
                [1][3] -> [3][1]
                
                [2][3] -> [3][2]

                all the [i][j] elements remains the same. here i == j.

                also loop are as follows
                i: 0 -> length(matrix)
                j: i+1 -> length(matrix[i]).

            - Reverse each row
                - traverse for row and col
                - for swaping rows. we use
                - temp = matrix[row][col];
                    matrix[row][col] = matrix[row][len-1-col];
                    matrix[row][len-1-col] = temp;
                - loops
                    - col: 0 -> n/2
                    - row: 0 -> n
            
        */
        // TRANSPOSE
        for(int i = 0; i< matrix.length; i++){
            for(int j = i+1 ; j < matrix[i].length; j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        //Reverse rows i.e swap every row.
        int n = matrix.length;
        for(int col = 0; col < n/2; col++){
            for(int row = 0; row < n; row++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][n-1-col];
                matrix[row][n-1-col] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15, 16}};
        System.out.println("matrix");
        for(int[] i: matrix){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }

        rotate(matrix);

        System.out.println("90 deg Matrix");
        for(int[] i: matrix){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}