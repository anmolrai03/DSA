
package Arrays.Medium;
import java.util.*;

public class SortZeroOneTwo {
    public static void sort012(int[] arr)
    {
        //Write your code here
        /* BRUTE FORCE : use  merger sort*/

        /*BETTER */
        /* 
            int[] freqArray = new int[3];
            for(int i = 0; i < arr.length ; i++){
                freqArray[arr[i]]++;
            } // O(n)
            int idx = 0;
            for(int j = 0 ; j < 3 ; j++){
                while(freqArray[j]-- > 0){
                    arr[idx] = j;
                    idx++;
                    // j--;
                }
            }
        */

        /* 
        OPTIMAL
            - Dutch National Flag Algorithm (DNF).
            - 
        */
    }

    public static void main(String[] args) {
        int[] arr = {0 , 1, 2, 0 , 1, 2, 1, 2, 0, 0, 0 ,1};
        sort012(arr);
        System.out.println(Arrays.toString(arr));
    }
}
