package recursion.basic;

public class Core {
   //print 5 times
   static void print5(int n){
      if(n == 6){
         System.out.println();
         return;
      }
      System.out.print(n+" ");
      print5(n+1);
   }

   //1 to n.
   static void display(int n){
      if(n == 0){

         return;
      }

      display(n-1);
      System.out.print(n+" ");
   }

   //n to 1;
   static void show(int n){
      if(n == 1){
         System.out.println(1);
         return;
      }
      System.out.print(n+" ");
      show(n-1);
   }

   //sum of first n numbers.==> Parameterised Way.
   static int sumPara(int n , int sum){
      if(n < 1){
         return sum;
      }

      sum += n;
      return sumPara(n-1, sum);
   }

   //functional.
   static int sumFunc(int n){
      if( n == 0){
         return 0;
      }

      return n + sumFunc(n-1);
   }

   //functional. factorial
   static int factorial(int n){
      if( n == 1){
         return 1;
      }

      return n * factorial(n-1);
   }

   public static void main(String[] args) {
      //print 5 times.
      print5(1);

      //print 1 to n.
      display(7);
      System.out.println();

      //print n to 1.
      show(8);

      //sum
      int para = sumPara(25 , 0);
      System.out.println(para);

      int func = sumFunc((int)Math.pow(10,4));
      System.out.println(func);

      System.out.println(factorial(5));
   }
}
