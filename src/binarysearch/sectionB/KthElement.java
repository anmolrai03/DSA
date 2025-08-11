package binarysearch.sectionB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class KthElement {
   public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
      // Write your coder here
      arr1.addAll(arr2);
      Collections.sort(arr1);
      System.out.println(arr1);
      return arr1.get(k-1);
   }

   public static void main(String[] args) {
//       [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
      ArrayList<Integer> arr1 = new ArrayList<>();
      arr1.add(2);
      arr1.add(3);
      arr1.add(45);
      ArrayList<Integer> arr2 = new ArrayList<>();
      arr2.add(4);
      arr2.add(6);
      arr2.add(7);
      arr2.add(8);
      System.out.println(kthElement(arr1, arr2,arr1.size() , arr2.size() , 4));
   }
}
