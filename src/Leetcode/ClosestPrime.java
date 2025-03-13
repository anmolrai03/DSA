package Leetcode;
import java.util.Arrays;
import java.util.Scanner;


public class ClosestPrime {
   public static int[] closestPrimes(int left, int right) {
      int[] ans = {-1,-1};
      int minDist = Integer.MAX_VALUE;
      int i = left;
      int j = left;
      while(j <= right){
         if(isPrime(j)){
            if(i != j && isPrime(i)){
               if(minDist > j -i){
                  minDist = j - i;
                  ans[0] = i;
                  ans[1] = j;
               }
            }
            i = j;
         }
         j++;
      }
      return ans;
   }
   private static boolean isPrime(int num){
      if(num < 2 ) return false;
      if(num == 2) return true;
      for(int i = 2; i * i <= num; i++){
         if(num % i == 0){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
//      System.out.println("Enter num" );
//      int num = sc.nextInt();
//      for(int i = 0; i < 20; i++){
//
//      System.out.println(i+ ": " +isPrime(i));
//      }
      int left = sc.nextInt();
      int right = sc.nextInt();
      System.out.println(Arrays.toString(closestPrimes(left, right)));
   }
}
