package binarysearch.sectionB;

public class KthMissing {
   public static int missingK(int[] vec, int n, int k) {
      // Write your code here.
      int missing = k;
      boolean resultFound = false;
      while(!resultFound){
         for(int num: vec){
            if(num == missing){
               missing++;
               break;
            }
         }
         resultFound = true;
      }
      return missing;
   }

   public static void main(String[] args) {
      int[] vec = {4, 5, 7,10};
      int n = vec.length;
      int k = 4;
      System.out.println(missingK(vec , n, k));
   }
}
