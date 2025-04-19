package Leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//38.
public class CountAndSay {

   public static void main(String[] args) {
//      System.out.println(rle("3322251"));
//      System.out.println(countAndSay(4));
//      System.out.println(countAndSay(1));
//      System.out.println(countAndSay(30));
//      System.out.println(countAndSay(5));
//      System.out.println(rle("1211"));
//      System.out.println("4"+'i');
//      System.out.println(4 + ""+'a');
//      System.out.println(countAndSay(4));
//      System.out.println(rle("1211"));
      System.out.println(rle("111221"));
   }

   public static String countAndSay(int n) {
      //base case
      if(n== 1){
         return "1";
      }

      return rle(countAndSay(n-1));
   }

   private static String rle(String s){
      int n = s.length();

      StringBuilder ans = new StringBuilder();
      int count = 0;
      int l = 0; int r = 0;
      while(r <= n){
         if(r == n){
            ans.append(count).append(s.charAt(l));
            break;
         }
         if(s.charAt(l) == s.charAt(r)){
            count++;
            r++;
         } else{
            ans.append(count).append(s.charAt(l));
            l = r;
            count = 0;
         }
      }

      return ans.toString();
   }
}
