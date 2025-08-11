package slidingwindow.medium;

public class BinarySum {
   public static int numSubarraysWithSum(int[] nums, int goal) {
      int ans = subArrayK(nums , goal) - subArrayK(nums , goal-1);
      return ans;
   }

   //subarrays with sum <= k
   private static int subArrayK(int[] nums, int goal) {
      if(goal < 0) return 0;
      int l = 0; int r = 0; int sum =0;
      int subArrayCount = 0;
      int n = nums.length;
      while(r < n){
         sum += nums[r];
         while(l < r && sum > goal){
            sum -= nums[l];
            l++;
         }
         subArrayCount += ((r-l)+1);
         r++;
      }
      return subArrayCount;
   }


   public static int numSubarraysWithSum1(int[] nums, int goal) {
      //Brute Force Approach.
      int n = nums.length;
      int ans = 0;
      for(int i = 0; i < n; i++){
         int sum = 0;
         for(int j = i; j < n ; j++){
            sum += nums[j];
            if(sum == goal){
               ans++;
            }
            if(sum > goal){
               break;
            }
         }
      }
      return ans;
      /*
      int l = 0; int r = 0; int sum = 0; int ans = 0;
      int n = nums.length;
      while( r < n ){
         sum += nums[r];
         if(sum > goal){
            sum -= nums[l];
            l++;
         }

         if(sum == goal){
            ans++;
         }
         r++;
      }

      while(l >= 0 && l < n && sum >= goal){
         sum -= nums[l];
         if(sum == goal){
            ans++;
         }
         l--;
      }
      return ans;
      */
   }

   public static void main(String[] args) {
      int[] nums = {1,0,1,0,1};
//      int[] nums = {0,0,0,0,0};
//      System.out.println(subArrayK(nums , 2));
//      System.out.println(subArrayK(nums , 1));
      System.out.println(numSubarraysWithSum(nums , 2));
   }

}
