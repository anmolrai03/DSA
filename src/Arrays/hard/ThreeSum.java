package Arrays.hard;
import java.util.*;

public class ThreeSum {
    public static List< List < Integer > > triplet(int n, int []arr) {
        // Write your code here.
        //BRUTE FORCE
        /*
            - find all triplets possible
            - check if the sum == 0;
            - add to the result if above condition is satisfied
        */

        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i<n; i++){
            for(int j = i+1; j < n ; j++){
//                List<Integer> list ;
                for(int k = j+1; k < n ; k++){
                    if(arr[i]+ arr[j] + arr[k] == 0 ){
                        List<Integer> list = Arrays.asList(arr[i] , arr[j] , arr[k]);
//                        list = Arrays.asList(arr[i] , arr[j] , arr[k]);
                        list.sort(null);
                        st.add(list);
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(st);
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {-1,-1,2,0,1};
        int[] arr1 = {0 ,0 ,0 ,0};
        int n = arr.length;
        System.out.println(triplet(n,arr));
        System.out.println(triplet(arr1.length,arr1));
    }
}
