package Arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

        int n = 8;
//        int[][] res = pascalTriangle(9);
//        System.out.println(Arrays.toString(Arrays.toString(pascalTriangle(4))));
//        System.out.println(Arrays.toString(res));
//        for(int[] i: res){
//            for(int j : i){
//                System.out.print(j+ " ");
//            }
//            System.out.println();
//        }
//        System.out.println(nCr(10,3));
        System.out.println(pascalRow(n));
    }

    private static int nCr(int n , int r){
        if(n== r){
            return 1;
        }
        if(r == 0){
            return 1;
        }
        if(r == 1){
            return n;
        }

//        int res = fact(n) / (fact(n-r)* fact(r));
        int res1  = 1;
        for(int i = 0; i<r; i++){
            res1 *= (n-i);
            res1 /= (i+1);
        }
        return  res1;
    }

    private static int fact(int n){
        if(n ==0 || n == 1){
            return 1;
        }
        int factorial = 1;
        for(int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }

    //PRINT PASCAL TRIANGLE TILL GIVEN ROW
    public static int[][] pascalTriangle(int N) {
        // Write your code here.
        //It uses nCr.
        /*
            - 1st row is 1.
            - 2nd row is 1C0 1C1
            - 3rd row is 2C0 2C1 2C2
            - 4th row is 3C0 3C1 3C2 3C3
            .........
            - nth row is (n-1)C(r) where r: 0 t0 n-1

            nCr = n!/(n-r)!* r!
        */

        //BRUTE
        /*
            - find (n-i)/(i+1);
            - till i < r;
        */
        int[][] arr = new int[N][];
        for(int i = 0; i<N; i++){
            arr[i] = new int[i+1];
            for(int r = 0; r <= i; r++){
                arr[i][r] = nCr(i ,r);
            }
        }
        return arr;
    }
    public static List<Integer> pascalRow(int row){
        List<Integer> res = new ArrayList<>();
        int ans = 1;
        res.add(ans);
        for(int i = 1 ; i< row ; i++){
            ans *= (row-i);
            ans /= i;
            res.add(ans);
        }
        return res;
    }
}
