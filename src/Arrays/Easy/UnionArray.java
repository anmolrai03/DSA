package Arrays.Easy;
import java.util.*;

public class UnionArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3};
        int[] arr2 = {2, 2, 4};
        List<Integer> ans = sortedArray(arr1, arr2);
        System.out.println(ans);
    }
    

    public static List< Integer > sortedArray(int []a, int []b){
        //Added two arrays in set data structure which stores only unique elements in of the array.
        // int m = a.length;
        // int n = b.length;
        
        Set<Integer> st = new HashSet<>();
        for(int i : a){
            st.add(i);
        }

        for(int j : b){
            st.add(j);
        }
        List<Integer> list = new ArrayList<>();
        for(int k : st){
            list.add(k);
        }
        return list;
    }
}
