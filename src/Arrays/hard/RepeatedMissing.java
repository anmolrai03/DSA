package Arrays.hard;

import java.util.Arrays;

public class RepeatedMissing {
    public static int[] findMissingRepeatingNumbers(int []a) {
        // Write your code here
        int[] arr = new int[2];//arr[0] = repeated , arr[1] = missing;
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int presentSum = 0;

        //finding sum;
        boolean isRepeatedNumberFound = false;
        for(int i = 0; i < a.length ; i++){
            presentSum += a[i];

            //if Repeated Number is found don't check in here again.
            if(!isRepeatedNumberFound && (a[i] != i+1)){
                arr[0] = a[i];
                isRepeatedNumberFound  = true;
            }
        }

        //finding missing number
        // for(int i = 0 ; i< a.length ; i++){
        //     if(a[i] != i+1){
        //         arr[0] = a[i];
        //         break;
        //     }
        // }
        int totalSum = (a.length * (a.length + 1))/2;
        arr[1] = totalSum - (presentSum-arr[0]);// missing number = totalSum - (presentSum - repeated)
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {10 ,11, 1, 12 ,3, 4 ,13 ,8, 2 ,6, 7, 9, 5, 3};
        int[] arr1 = {8 ,4 ,1 ,6 ,7 ,2 ,5, 8};
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr)));
        System.out.println(Arrays.toString(findMissingRepeatingNumbers(arr1)));
        
    }
}
