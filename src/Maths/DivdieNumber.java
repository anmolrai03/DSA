package maths;

public class DivdieNumber {
   public static int divide(int dividend, int divisor) {
      int sign = 1;
      if(divisor < 0){
         divisor = -1*divisor;
         sign = -1;
      }

      int quo = 0;
      while(dividend >= 0){
         dividend -= divisor;
         if(dividend < 0){
            break;
         }
         quo++;
      }

      if(quo >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
      if(quo <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
      return sign*quo;
   }

   public static void main(String[] args) {
      System.out.println(divide(10 , 3));
      System.out.println(divide(7 , -3));
      System.out.println(divide(2^31 , 3));
      System.out.println(-2147483648-(-1));
   }
}
