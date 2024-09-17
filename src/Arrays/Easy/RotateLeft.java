package Arrays.Easy;

import java.util.Arrays;

public class RotateLeft {
    static int[] rotateArray(int[] arr, int n) {

        if(n == 0 || n == 1){
            return arr;
        }
        // Write your code here.
        int temp = arr[0];
        for(int i = 1 ; i < n ; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = temp;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1 , 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(rotateArray(arr , arr.length)));
    }
}
