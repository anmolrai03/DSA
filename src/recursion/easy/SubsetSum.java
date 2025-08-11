package recursion.easy;

public class SubsetSum {
   public static int findWays(int num[], int tar) {
      // Write your code here.
      return helper(num ,tar , 0, 0);
   }

   private static int helper(int[] num  , int tar , int sum, int idx){

      //base condition.
      if(sum > tar) return 0;
      if(sum == tar){
         return 1;
      }
      if(idx == num.length){
         return 0;
      }

      //pick not pick's sum
      return (helper(num ,tar , sum +num[idx] , idx+1) + helper(num , tar , sum , idx+1));
   }

   public static void main(String[] args) {
      System.out.println(findWays(new int[]{1,1,4,5} , 5));
      System.out.println(findWays(new int[]{2, 2 ,1 ,7, 3, 3, 1, 7, 9, 6 ,7, 4 ,2 ,7, 5 } , 7));
      System.out.println(findWays(new int[]{12 ,14, 3 ,18, 2} , 13));
   }
}
