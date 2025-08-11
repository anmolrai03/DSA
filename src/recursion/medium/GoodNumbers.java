package recursion.medium;

import java.util.Scanner;

public class GoodNumbers {

   public static int countGoodNumbers(long n) {
      long evenLen = 0; long oddLen = 0;

      if( n % 2 == 0){
         evenLen = n/2;
      } else {
         evenLen = n/2  + 1;
      }
      oddLen = n/2;

      System.out.println("evenLen: "+evenLen);
      System.out.println("oddLen: "+oddLen);

      long evenWays = pow(5, evenLen);
      long oddWays = pow(4, oddLen);
      System.out.println(evenWays);
      System.out.println(oddWays);

      return (int) ( (evenWays * oddWays) % 1000000007);
   }

   static long pow(long base , long power){

      if( power == 0) return 1;
      if( power == 1) return base;

      long res = 1;

      while( power > 1 ){
         if( power % 2 == 0){
            base = (base * base)  % 1000000007;
            power = power /2;
         } else {
            res = (res * base) % 1000000007 ;
            power -= 1;
         }
      }
      return (res * base) % 1000000007 ;
   }

   static boolean isGoodNum(long num , long len){

      if(len <= 0) return true;

      long rem = num % 10;
      // even index
      if( (len % 2)-1 == 0){
         if( rem % 2 == 0 ){
            return isGoodNum(num/10 , len -1);
         }
      }
      // odd index
      else{
         if( rem == 2 || rem == 3 || rem == 5 || rem == 7){
            return isGoodNum(num/10 , len -1);
         }
      }
      return false;
   }

   public static void main(String[] args) {
//      Scanner sc = new Scanner(System.in);
//      long num = sc.nextLong();
//      long len = (long)(Math.log10(num)) + 1;
//      System.out.println(isGoodNum(num ,len ));
//      System.out.println(pow(5, 10));
//      System.out.println(Math.pow(5,  10));
//      System.out.println(countGoodNumbers(51));
      System.out.println(countGoodNumbers(1954));
   }


   
}
