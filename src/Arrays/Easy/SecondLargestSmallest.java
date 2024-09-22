package Arrays.Easy;
import java.util.Arrays;
public class SecondLargestSmallest {
    public static int[] getSecondOrderElements(int n, int []a) {
        
        // Write your code here.
        int[] ans = new int[2];

        ans[0] = secondLargestNumber(n, a);
        ans[1] = secondSmallestNumber(n,a);
        return ans;
    }

    private static int secondSmallestNumber(int n, int[] arr) {
        //find smallest
        //Using two passes
        
        int small = Integer.MAX_VALUE;
        for(int i = 0; i< n;i++){
            if(arr[i] < small){
                small = arr[i];
            }
        }

        int second_small = Integer.MAX_VALUE;
        for(int i = 0; i< n;i++){
            if(arr[i] < second_small && arr[i] != small){
                second_small = arr[i];
            }
        }
        return second_small;
    }

    private static int secondLargestNumber(int n , int[] arr){
        // Using two passes 
        int large = Integer.MIN_VALUE;
        for(int i = 0; i< n;i++){
            if(arr[i] > large){
                large = arr[i];
            }
        }

        int second_large = Integer.MIN_VALUE;
        for(int i = 0; i< n;i++){
            if(arr[i] > second_large && arr[i] != large){
                second_large = arr[i];
            }
        }

        return second_large;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3,4, 5};
        System.out.println(Arrays.toString(getSecondOrderElements(a.length,a)));
    }
}
