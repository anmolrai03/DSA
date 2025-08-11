package Sept.CoreRecursion;

public class BasicSol {

   // factorial
   public static int fact(int n) throws Exception{

      // base case
      if( n == 1 || n == 0) return 1;
      // throw error if n < 0 , i.e factorial for -ve number is not defined
      if( n < 0){
         throw new Exception("Factorial for negative number is not defined.");
      }

      // recursive case
      return n * fact(n-1);

   }

   // fibonacci
   public static int fibo(int n){

      // base case
      if(n <= 0) return 0;
      if( n == 1) return 1;

      // recursive case.
      return fibo(n-1) + fibo(n-2);

   }

   public static int negaFibo(int n){
      int pos = -1 * n;
      return (int)Math.pow(-1 , pos+1) * fibo(pos);
   }

   // sum of array
   public static int sumOfArray(int[] nums ){
      if(nums.length == 0) return 0;
      return helper(nums, 0);
   }

   private static int helper(int[] nums , int i){
      // base case
      if( i == nums.length-1) return nums[i];
      // recursive case.
      return nums[i] + helper(nums, i+1);
   }

   // pow(x, n)
   public static float pow(int base , int power){

      // negative powers
      if(power < 0) {
         power = -1 * power;
         return 1 / pow(base , power);
      }

      // base case
      if( power == 0) return 1;
      if(power == 1) return base;

      // recursive case
      if( power % 2 == 0){
         return pow(base * base , power/2);
      }
      return base * pow(base , power-1);
   }

   public static void main(String[] args) throws Exception {

//      System.out.println(fact(8));

//      System.out.println(fibo(4));
//      System.out.println(negaFibo(-4));

      // print fibo till n
      int n = 4;
      for(int i = 0; i <= n; i++){
         if(i == n) System.out.println(fibo(i));
         else System.out.print(fibo(i)+", ");
      }

      // sum of array
      System.out.println(sumOfArray(new int[]{4, 8 , 12}));

      // power function
      System.out.println(pow(5, 9));
   }

}
