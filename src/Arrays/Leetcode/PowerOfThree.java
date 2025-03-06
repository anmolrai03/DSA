package Arrays.Leetcode;

import java.util.Scanner;

// 4th march.
public class PowerOfThree {
   public static boolean checkPowersOfThree(int n) {
//      int rangeEnd = (int) (Math.log10(n)/Math.log10(3));
      int i = 0;
      int sum = 0;

      //Step 1: Go forward.
      while(sum <= n){
         sum += (int) Math.pow(3,i);
         i++;
         if(sum == n){
            return true;
         }
      }

      //Step 2: Check if possible.
      int diff = sum - n;
       i = i-1;
      while( i >= 0){
         int num = (int) Math.pow(3 , i);
         if(num == diff){
            return true;
         }
         else if(num > diff){
            i--;
         }
         else if(num < diff){
            diff = diff - num;
            i--;
         }

      }
      return false;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      System.out.println(checkPowersOfThree(n));
   }
}
