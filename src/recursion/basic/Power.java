package recursion.basic;

public class Power {
   public static double helper(double x , long n){
      if(n == 0){
         return 1;
      }

      if(n % 2 == 0){
         return helper(x * x , n/2);
      }
      return x * helper(x , n-1);

      //n % 2 == 0 ==> x * x, n /2
      //n % 2 == 1 ==> ans = ans * x; , n = n-1;
   }

   public double myPow(double x, int n) {
      long N = n;
      if(n < 0){
         return (double) 1/ helper(x , -1*N);
      }
      return helper(x , N);

   }

   public static void main(String[] args) {
      Power p = new Power();
      System.out.println(p.myPow(3,4));
      System.out.println(p.myPow(2,10));
      System.out.println(p.myPow(2,-4));
      System.out.println(p.myPow(2,-2));
      System.out.println(p.myPow(2 , 50));
//      System.out.println(p.myPow(2,-200000000));
//      System.out.println(Math.pow(2 , -200000000));

   }
}
