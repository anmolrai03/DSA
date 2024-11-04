package Arrays.Easy;

import java.util.HashMap;

public class LongestSubarray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1,1,1,1};
        int k = 3;
        System.out.println(longestSubarrayWithSumK(a,k));
    }

    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        //BRUTE FORCE
        /*Find all the possible subarrys sum them and check for the largest subarray with sum k*/
//        for(int i = 0; i< a.length; i++){
//            int sum = 0;
//            int count = 0;
//            for(int j = i ; j< a.length ;j++){
//                sum += a[j];
//                count++;
//                if(sum == k){
//                    max = Math.max(count,max);
//                }
//            }
//        }

        HashMap<Long , Integer> preSum = new HashMap<>();
        long sum = 0;
//        int len = 0;
        for(int i = 0 ; i < a.length ; i++){
            int len = 0;
            sum += a[i];

            if(sum == k){
                len = i+1;
                max = Math.max(max, len);
            }

            long remain =  sum - k;

            if(preSum.containsKey(remain)){
                len = i - preSum.get(remain);
                max = Math.max(len , max);
            }

            if(!preSum.containsKey(sum)){
                preSum.put(sum , i);
            }
        }
        return max;
    }
}
