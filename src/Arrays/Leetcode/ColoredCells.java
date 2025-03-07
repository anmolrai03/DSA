package Arrays.Leetcode;

import java.util.Scanner;

//March 5 : 2579
public class ColoredCells {
   public static long coloredCells(int n) {

      //Brute force.
      /*
      if(n == 0) return 0;
      if(n == 1){
         return 1;
      }
      long ans = 1;
      for(int i = 1 ; i < n ; i++){
         ans += (4*i);
      }
      return ans;
       */
      // it is a Progressive Arithmetic Progression. so the nth term is the ans.
      long num = n;


      return 1+(2*num*(num-1));
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a number: ");
      int num = sc.nextInt();

      System.out.println(coloredCells(num));
   }
}
