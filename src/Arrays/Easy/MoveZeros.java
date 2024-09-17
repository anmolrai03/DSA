package Arrays.Easy;

import java.util.Arrays;

public class MoveZeros {



    public static int[] moveZeros(int n, int []a) {
        // Write your code here.
        // BRUTE FORCE
        /*
            - move all non-zero in temp.
            - keep count of no of zeros.
            - add count number of zeros at the end of temp array.

            - Complexity.
            - Time: O(n) - for two passes.
            - Space: O(n) - for temp array.
        */

        //OPTIMAL APPROACH
        /*
            fint first zero;
            j = first zero index;
            i = j + 1;
            if(arr[i] != 0){
                swap(arr[j++] , arr[i++])
            }
            else{
                i++
            }
        */

        //Find first zero.
        int firstZero = -1;
        for(int i = 0 ; i < n; i++){
            if(a[i] == 0){
                firstZero = i;
                break;
            }
        }

        if(firstZero == -1){
            return a;
        }

        //Pull zeros at last
        int j = firstZero;
        int i = j + 1;
        while(i < n){
            if(a[i] != 0)
            {
                swap(a, i++ , j++);
            } else {
                i++;
            }
        }

        return a;
    }

    private static void swap (int[] arr , int f , int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }
    public static void main(String[] args) {
        // int[] arr = {1 , 2, 2, 0 , 0 , 3, 2};
        int[] arr = {1 ,0 , 2, 3, 2, 0 , 0 , 4 , 5, 1};
        System.out.println(Arrays.toString(moveZeros(arr.length , arr)));
    }
    
}
