package recursion.basic;

public class Knapsack {
   static int knapsack(int[] items , int [] val , int W , int n){
      //base condition.
      if(n == 0 || W == 0){
         return 0;
      }

      //recursive condition.

      if(W >= items[n-1]){
         //                          picking                        not pick
         return Math.max(val[n-1] + knapsack(items , val , W-items[n-1] , n-1) , knapsack(items ,
             val , W ,
             n-1));
      }

      return knapsack(items, val ,  W , n-1);
   }

   //unbounded
   static int knapsackUn(int[] items , int[] val , int W , int n){
      //base conditon.
      if (W == 0 || n == 0) {
         return 0;
      }

      //recursive calls
      if(W >= items[n-1]){
         //picking , not picking.
         return Math.max(val[n-1] + knapsackUn(items , val , W-items[n-1] , n) , knapsackUn(items
             , val , W , n-1));
      }
      return knapsackUn(items , val , W , n-1);
   }

   public static void main(String[] args) {
      int[] items = {7 , 2, 3, 5};
      int[] val = {20 , 15 , 8 , 7};

      System.out.println(knapsack(items, val , 10 , 4));
      System.out.println(knapsackUn(items, val , 10 , 4));
   }
}
