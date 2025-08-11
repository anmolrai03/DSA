package dynamicProgramming.knapsack;

public class Knapsack01 {
   public static void main(String[] args) {
      int[] w = {7 , 2, 3, 5};
      int[] p = {20 , 15, 8, 7};
      System.out.println(knapsackRecursive(p.length-1 , w , p , 10));
      System.out.println(knapsackDP(p.length , p , w , 10));
   }

   //dp
   public static int knapsackDP(int n , int[] p , int[] w , int W){

      int[][] dp = new int[n+1][W+1];

      for(int i = 0; i <= n; i++){
         for(int wt = 0; wt <= W; wt++){

            if(i == 0 || W == 0){
               dp[i][wt] = 0;
            }
            else if(wt >= w[i-1]){
               int pick = 0;
               if(wt-w[i-1] >= 0 && wt-w[i-1] <= W){
                  pick = dp[i-1][wt-w[i-1]] + p[i-1];
               }

               int notPick =  dp[i-1][wt];

               dp[i][wt] = Math.max(pick , notPick);

            } else{
               dp[i][wt] = dp[i-1][wt];
            }
         }
      }
      return dp[n][W];
   }

   //recursive
   public static int knapsackRecursive(int n , int[] w , int[] p , int W){
      if(n == 0 || W == 0) return 0;

      if(W >= w[n-1]){
         //              profit at n-1 + pick                                        ,   not pick
         return Math.max(p[n-1] + knapsackRecursive(n-1 , w , p , W-w[n-1]) , knapsackRecursive(n-1 , w , p , W));
      }
      return knapsackRecursive(n -1 , w , p , W);
   }

   private static boolean sumExists(int[] arr , int tar , int n){
      for(int i = 0; i < n; i++){
         for(int j = 0; j < n ;j++){
            if(arr[i] + arr[j] == tar){
               return true;
            }
         }
      }
      return false;
   }
}
