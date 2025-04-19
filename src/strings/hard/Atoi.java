package strings.hard;

import java.util.Scanner;

public class Atoi {

   public static boolean isDigit(char ch){
      if(ch == '0' ||
          ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9'){
         return true;
      }
      return false;
   }


   public static int myAtoi(String s) {
      int n = s.length();
      int i = 0;
      int sign = 1;
      long res  = 0;

      //Step 1: Remove leading spaces.
      while(i < n && s.charAt(i) == ' '){
         i++;
      }

      //first char after space for sign
      if(i < n && s.charAt(i) == '-'){
         sign *= -1;
         i++;
      }
      else if(i < n && s.charAt(i) == '+'){
         i++;
      }

      while(i < n && isDigit(s.charAt(i))){
         int currNum = s.charAt(i) - '0';
         if(res == 0 && currNum == 0){
            i++;
            continue;
         }

         res = res * 10 + currNum;

         long temp = sign * res;
         if(temp >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
         }

         if(temp <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
         }

         i++;
      }


      return sign * (int)res;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
//      String s = sc.next();
//      System.out.println(myAtoi(s));
      System.out.println(myAtoi("  -042"));
//      System.out.println(myAtoi(" "));
//      System.out.println(myAtoi("-+12"));
      sc.close();
   }
}
