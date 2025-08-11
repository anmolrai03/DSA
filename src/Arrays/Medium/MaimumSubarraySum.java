package Arrays.Medium;
import java.util.Arrays;

public class MaimumSubarraySum {
    public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
        //Kadane's Algo
        /*
            - take sum = 0;
            - sum += arr[i];
            - max_so_far = Maximum (max_so_far , sum);
            - if sum < 0;
            - sum = 0;
        */
        long max = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i< n ; i++){
            sum += arr[i];

            max = Math.max(max,sum);

            if(sum < 0){
                sum = 0;
            }
        }
        if (max < 0){
            return 0;
        }
        
        return max;
	}
    public static int[] maxSubarrayList(int[] arr, int n){
        long max = Long.MIN_VALUE;
        long sum = 0;
        int startIdx = -1;
        int[] ans = new int[2];
        for(int i = 0; i< n ; i++){
            if(sum == 0) startIdx = i;
            sum += arr[i];

            if(sum > max){
                max = sum;
                ans[0] = startIdx;
                ans[1] = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }
        
        
        return ans;
    }


    static int maxSubSumArray1(int[] arr){
        if(arr.length == 0){
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        int sum = 0;
        for(int num: arr){
            sum += num;
            if(sum < 0){
                sum = 0;
            }
            maxSum = Math.max(maxSum , sum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = { 1, 2, 7, -4, 3, 2, -10, 9, 1};

        System.out.println(maxSubarraySum(arr , arr.length));
        System.out.println(Arrays.toString(maxSubarrayList(arr, arr.length)));
        System.out.println((maxSubSumArray1(arr)));
    }
}
