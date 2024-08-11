package Arrays;

import java.util.Scanner;

public class largestElement {

    private static int largestNumber(int[] arr){

        if(arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return arr[0];
        }
        
        int largest = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n ; i++){
            int val = sc.nextInt();
            arr[i] = val;
        }
        sc.close();
        
        System.out.println(largestNumber(arr));
    }
}
