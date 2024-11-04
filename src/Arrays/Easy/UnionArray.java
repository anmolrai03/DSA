package Arrays.Easy;
import java.util.*;

public class UnionArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4,6};
        int[] arr2 = {2,3,5};
        List<Integer> ans = sortedArray(arr1, arr2);
        System.out.println(ans);
    }
    

    public static List< Integer > sortedArray(int []a, int []b){
        //Added two arrays in set data structure which stores only unique elements in of the array.
        // int m = a.length;
//        List<Integer> list = new ArrayList<>();
//        int i = 0, j=0;
//        while(i < a.length && j < b.length){
//            if(a[i] == b[j]){
//                list.add(a[i]);
//                i++;
//                j++;
//            } else if(a[i] < b[j]){
//                list.add(a[i]);
//                i++;
//            } else{
//                list.add(b[j]);
//                j++;
//            }
//        }
//
//        while(i < a.length){
//            list.add(a[i++]);
//        }
//        while(j < b.length){
//            list.add(b[j++]);
//        }

        HashSet<Integer> set = new HashSet<>();
        for(int val: a){
            System.out.println(val);
            set.add(val);
        }
        for(int val: b){
            System.out.println(val);
            set.add(val);
        }
        List<Integer> ans = new ArrayList<>(set);
        ans.sort(null);
        return ans;
    }
}
