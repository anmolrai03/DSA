package slidingwindow.medium;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringI {
   public static int lengthOfLongestSubstring(String s) {
      int maxLength = 0;
      int left = 0; int right = 0;
      int n = s.length();
      HashMap<Character , Integer > map = new HashMap<>();

      while(right < n){
         char ch = s.charAt(right);

         if(map.containsKey(ch)){
            int val = map.get(ch);
            if(left <= val){
               left = val +1;
            }else{
               maxLength = Math.max((right - left) + 1 , maxLength);
            }
            map.replace(ch , right);
         } else{
            map.put(ch , right);
            maxLength = Math.max((right - left) + 1 , maxLength);
         }
         right += 1;
      }
      return maxLength;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s= sc.next();
      System.out.println(lengthOfLongestSubstring(s));
   }
}
