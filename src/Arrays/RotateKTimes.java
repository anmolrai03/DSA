package Arrays;

import java.util.Arrays;
public class RotateKTimes {


    /*
        Left rotation means : arr = [1, 2 , 3, 4, 5 , 6 , 7 , 8 , 9 ];
        for d = 2 left rotations : arr = [3, 4, 5 , 6 , 7 , 8 , 9 , 1 , 2];

        for a rotation of length size original array is returned back.
        so no of rotation required will be d % length of array

        temp = arr[d-1];// first d elements.

        for shifting start at i = d ; i < n ; i++
        arr[i-d] = arr[i]; // shifting rest to forward.

        for adding temp to rotated.
        temp = [] // j;

        j = 0;
        for (i = n-d ; i < n ; i++){
            arr[i] = arr[j]
            j++''
        }

    */
    static int[] kRotation(int[] arr , int d ){

        // edge cases if arr.length < d;
        if(arr.length == 0){
            return arr;
        }

        // General Cases.
        //No of rotation required
        d = d % arr.length;

        //storing first d elements in temp
        int[] temp = new int[d];
        for(int i = 0 ; i < d ; i++){
            temp[i] = arr[i];
        }

        // Shifting others by d times.
        for(int i = d ; i < arr.length ; i++){
            arr[i-d] = arr[i];
        }

        // Adding temp back at last;
        int j = 0;
        for(int i = arr.length -d ; i < arr.length ; i++){
            arr[i] = temp[j++];
        }

        //return the rotated array;
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2 , 3, 4, 5 , 6 , 7  , 8 , 9 };
        System.out.println(Arrays.toString(kRotation(arr , 11)));
    }
}
