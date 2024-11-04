package Arrays.Medium;

public class SubarraySum {

    //Find all subarray with target sum.
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        // Write your code here.    
        int n = arr.length;
        int subArrayCount = 0;
        //BRUTE FROCE SOLUTION.

        /* - Find every subarray sum it and check if the target is satisfied or not.
            - Time complexity: O(n*2).
            - Space complexity: O(1).
         */

        /* 
        int subArrayCount = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += arr[j];
                if(sum == s){
                    subArrayCount++;
                }
            }
        }
        return subArrayCount;

        */

        //BETTER.
        int i = 0;
        int j = 0;
        while(i< n){
            int sum = 0;
            while(j < n){
                sum += arr[j];
                if(sum == s){
                    subArrayCount++;
                    sum -= arr[i];
                    i++;
                }
                else if(sum > s){
                    sum -= arr[i];
                    i++;
                    if(sum == s){
                        subArrayCount++;
                    }
                }
                j++;
            }
            i++;
        }
        return subArrayCount;
    }

    public static void main(String[] args) {
        // int arr[] = {28,54,7,-70,22,65,-6};
        // int s = 100;
        int arr[] = {1,2,3};
        
        int s = 3;
        System.out.println(findAllSubarraysWithGivenSum(arr, s));
    }
    
}
