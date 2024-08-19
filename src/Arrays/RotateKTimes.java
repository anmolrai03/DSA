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
        // O(d)
        int[] temp = new int[d];
        for(int i = 0 ; i < d ; i++){
            temp[i] = arr[i];
        }

        // Shifting others by d times.
        //O(n-d)
        for(int i = d ; i < arr.length ; i++){
            arr[i-d] = arr[i];
        }

        // Adding temp back at last;
        // O(d)
        int j = 0;
        for(int i = arr.length -d ; i < arr.length ; i++){
            arr[i] = temp[j++];
        }

        /*
            Time Complexity.
             => O(d) + O (n-d) + O(d); 
            Space Complexity.
             => O(d);

            for optimal approch remove extra space. For that do
            - reverseArr(0 , d);
            - reverseArr(d , n):
            - reverseArr ( 0 , n)
        */

        //return the rotated array;
        return arr;
    }

    private static void reverse(int[] arr , int s , int e){
        int start  = s , end = e;
        // int mid = s + (e-s)/2;
        while (start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
    }

    static int[] reverseRotate(int[] arr , int d){
        if(arr.length == 0){
            return arr;
        }

        d = d % arr.length;

        reverse(arr , 0 , d-1);
        // System.out.println("first rotation" + Arrays.toString(arr));
        reverse(arr, d , arr.length-1);
        // System.out.println("second rotation" + Arrays.toString(arr));
        reverse(arr , 0 , arr.length -1);
        // System.out.println("final rotation" + Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2 , 3, 4, 5 , 6 , 7  , 8 , 9 };
        int d = 11;
        // System.out.println("using kRotation \n"+Arrays.toString(kRotation(arr , 11)));
        // System.out.println("before reverse" + Arrays.toString(arr));
        // reverse(arr, 0, 3);
        // System.out.println("After reverse"+Arrays.toString(arr));
        // System.out.println("using reverse method \n" + Arrays.toString(reverseRotate(arr, 11)));
        // reverse(arr , 0 , d-1);
        // System.out.println(Arrays.toString(arr));
        // reverse(arr , d , arr.length - 1);
        // System.out.println(Arrays.toString(arr));
        // reverse(arr , 0 , arr.length - 1);
        // System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(reverseRotate(arr, d)));
    }
}
