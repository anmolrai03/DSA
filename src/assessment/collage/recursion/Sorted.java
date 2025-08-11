package assessment.collage.recursion;

public class Sorted {
   public static void main(String[] args) {
      int[] arr = {1, 2, 13, 4, 5};
      System.out.println(isSorted(arr , 0));
   }

   static boolean isSorted(int[] arr , int idx){
      //base condition
      if(idx == arr.length - 1){
         return true;
      }

      return arr[idx] < arr[idx +1] && isSorted(arr , idx  + 1);
   }
}
