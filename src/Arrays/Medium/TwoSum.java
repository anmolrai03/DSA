package Arrays.Medium;
import java.util.*;

public class TwoSum {
    public static String read(int n, int []book, int target){

        /* 
        BRUTE FORCE 
            - take one element and check its sum with  other elements if found print YES otherwise NO.

            Time complexity O(n^2);
        */
        //code
        /* 
        for(int i = 0; i < n; i++){
            //for(int j = 0 ; j< n;j++) --> This is brute force
            for(int j = i+1; j < n; j++) 
            {
                if(book[i] + book[j] == target){
                    return "YES";
                }
            }
        }
        return "NO";
        */

        /*
            BETTER
            - Use Hash map 
            - iterate over a element check what is more needed to achieve the target .
            - find the number in hashmap .
            - if found return yes
            - if not map.add(arr[i] , i)
            - return no

            // code
            HashMap<Integer , Integer> map = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                int num = book[i];
                int moreNeeded = target - num;
                if(map.containsKey(moreNeeded)){
                    return "YES";
                }
                map.put(num , i);
            }
            return "NO";
        */

        /*
        OPTIMAL 
            - Sort The array put two pointers
            - start = 0 , end = arr.length - 1;
            // Logic - Code

        
        */
        Arrays.sort(book);
        int i = 0 ;
        int j = book.length - 1 ;
        while (i < j){
            int sum = book[i] + book[j];
            if(sum == target){
                return "YES";
            } else if(sum < target){
                i++;
            } else{
                j--;
            }
        }
        return "NO";

    }

    public static void main(String[] args) {
        int [] book = {2, 6, 5 , 8 , 11};
        int n = book.length;
        int target = 14;
        
        System.out.println(read(n, book, target));
    }
}
