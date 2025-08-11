package Leetcode;

public class TransformationI {
   public static int lengthAfterTransformations(String s, int t) {
      int n = s.length();
      int len = 0;
      for(int i = 0; i < n; i++){
         char ch = s.charAt(i);
         if(ch + t > 'z'){
            len = len + 2;
         }
      }
      return 0;
   }
}
