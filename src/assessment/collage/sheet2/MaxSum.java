package assessment.collage.sheet2;

public class MaxSum {

   static int maxArraySum(int[] nums , int k){

      int n = nums.length;
      if(k == 0) return 0;
      if(n == 0) return 0;
      if(k > n) return 0;

      int ans = Integer.MIN_VALUE;
      int l = 0;
      int r = k-1;

      //initial sum
      int sum = 0;
      for(int i = l ; i < k; i++){
         sum += nums[i];
      }

//      ans = sum;

      while(r < n){
         ans = Math.max(ans , sum);
         sum -= nums[l++];
         r++;
         if(r < n){
            sum += nums[r];
         }

      }
      return ans;
   }

   public static void main(String[] args) {
      int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
      int k = 3;
//      System.out.println(maxArraySum(nums , k));
      System.out.println(maxArraySum(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)); // Output: 16
      System.out.println(maxArraySum(new int[]{2, 4, 6, 8, 10}, 2)); // Output: 18
      System.out.println(maxArraySum(new int[]{-1, -2, -3, -4}, 2)); // Output: -3
      System.out.println(maxArraySum(new int[]{1}, 1)); // Output: 1
      System.out.println(maxArraySum(new int[]{}, 3)); // Output: 0
      System.out.println(maxArraySum(new int[]{5, 5, 5, 5}, 0)); // Output: 0
      System.out.println(maxArraySum(new int[]{1, 2, 3}, 5)); // Output: 0 (since k > n)
   }
}
