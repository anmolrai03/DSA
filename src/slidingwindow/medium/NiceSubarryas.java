package slidingwindow.medium;

public class NiceSubarryas {
   public int numberOfSubarrays(int[] nums, int k) {
      int n = nums.length;
      int ans = 0;
      int l = 0; int r = 0; int cnt =0;

      while(r < n){
         if(isOdd(nums[r])){
            cnt++;
         }
         if(cnt > k){
            while(!isOdd(nums[l])){
               l--;
            }
            l--;
            cnt--;
         }
         if(cnt == k){
            ans++;
            if(cnt>k){
               l++;
            }

         }
      }
      return ans;
   }

   private static boolean isOdd(int num){
      return num % 2 != 0;
   }
}
