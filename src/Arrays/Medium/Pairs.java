package Arrays.Medium;
import java.util.Arrays;


/* QUESTION:
  Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.
 */
public class Pairs{

    public static boolean canArrange(int[] arr, int k) {
        //BRUTE FORCE
        // 92/98 cases passed TLE error.
        int n = arr.length;
        int numberOfPairs = 0;
        boolean[] hash = new boolean[n];
        
        /* 
        int i = 0;
        while(i<n){
            int j = i+1;
            boolean flag = false;
            while(j<n){
                // System.out.println(j);
                if((!hash[i] && !hash[j]) && ((arr[i]+arr[j]) % k == 0)){
                    numberOfPairs++;
                    // System.out.println(arr[i]+" "+arr[j]);
                    hash[i] = true;
                    hash[j] = true;
                    flag = true;
                    
                    while(i<n && hash[i]){
                        i++;
                    }
                    break;
                }
                j++;
            }
            if(!flag){
                i++;
            }
        }
        */

        Arrays.sort(arr);
        int i = 0;
        int j = n-1;
        while(i<= j){
            if((!hash[i] && !hash[j])&&((arr[i]+arr[j]) % k == 0)){
                
                numberOfPairs++;
                hash[i] = true;
                hash[j] = true;
                i++;
                j--;
            }
            else if((arr[i] + arr[j])/ k > 0){
                j--;
            }else{
                i++;
            }
        }
        


        return numberOfPairs == n/2;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;
        // while(k<8){
        //     int j = 10;
        //     boolean flag = false;
        //     while(j < 13){
        //         if(j == 14){
        //             flag = true;
        //             break;
        //         }
        //         System.out.println(j);
        //         j++;
        //     }
        //     if(!flag){
        //         k++;
        //     }  else{
        //         break;
        //     }
            
            
        // }
        System.out.println(canArrange(arr, k));

    }
}