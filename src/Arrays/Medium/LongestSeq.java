package Arrays.Medium;

import java.util.*;

public class LongestSeq {
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        Arrays.sort(a);
        //BRUTE FORCE - USING STACK
        // Stack<Integer> st = new Stack<>();
        // int max = Integer.MIN_VALUE;
        // int count = 0;
        // for(int i = 0; i < a.length;i++){
        //     if(st.isEmpty()){
        //         st.push(a[i]);
        //     } else if(st.peek() != a[i] -1){
        //         count = 0;
        //         while(!st.isEmpty()){
        //             count++;
        //             st.pop();
        //         }
        //         max = Math.max(count , max);
        //         st.push(a[i]);
        //     } else if(i == a.length - 1){
        //         st.push(a[i]);
        //         count = 0;
        //         while(!st.isEmpty()){
        //             count++;
        //             st.pop();
        //         }
        //         max = Math.max(count , max);
        //     }else{
        //         st.push(a[i]);
        //     }
        // }
        // return max;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int i = 0 ;
        int j = i+1;
        while(i< a.length && j < a.length){
            if( Math.abs(a[i]-a[j]) == 1){
                count++;
                
            }else if(a[i] - a[j] == 0){
                //since after sorting duplicates will have differce zero but it can be just not considered for consecutive case as the questions calls for sorting only to make a longest possible sequence, not a madtory case to sort.
            }else{
                max = Math.max(max, count);
                count= 0;
            }
            i++;
            j++;
            if(j >= a.length){
                max = Math.max(max , count);
            }
            //To store the max if consecutive numbers are all the way till last.
        }
        return max+1;
        //Max + 1 because if 2 elements have difference as when it amounts for 2 counseutive number.

    }
    public static void main(String[] args) {
        // int[] a = {
        //     15 ,6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3 
        //     };
        //     Arrays.sort(a);

        //     System.out.println(Arrays.toString(a));
        // int[] a ={11, 12, 18 , 21, 22, 23, 24};
        int[] a ={1,2,2,1};
        System.out.println(longestSuccessiveElements(a));
    }
}
