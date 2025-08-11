package Leetcode;

import java.util.Scanner;

public class SubstringwithChars {
   public static int numberOfSubstrings1(String s) {
      int n = s.length();
      int ans = 0;
//      for(int i = 0 ; i< n ; i++){
//         for(int j = i+1 ; j < n; j++){
//            String toCheck = s.substring(i, j+1);
//            if(toCheck.contains("a") && toCheck.contains("b") && toCheck.contains("c")){
//               ans++;
//            }
//         }
//      }
      int i = 0;
      while(i < n){
         int j = i+1;
         boolean ansFound = false;
         while(j < n){
            String toCheck = s.substring(i, j+1);
            if(toCheck.contains("a") && toCheck.contains("b") && toCheck.contains("c")){
               ans = ans + (n - (j+1) +1);
               i++;
               ansFound = true;
               break;
            }
            j++;
         }
         if(!ansFound){
            i++;
         }

      }
      return ans;
   }

   public static int numberOfSubstrings(String s) {
      int n = s.length();
      int ans = 0;
      int i = 0;
      int j = i+1;
      while(i < n && j < n){
         String toCheck = s.substring(i , j+1);
         if(toCheck.contains("a") && toCheck.contains("b") && toCheck.contains("c")){
            ans = ans + (n - (j+1) +1);
            i++;
         } else {
            j++;
         }
      }
      return  ans;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(numberOfSubstrings(s));
   }
}
