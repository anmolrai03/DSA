package Leetcode;

//March 9 : 3208
public class AlternatingGroups {
   //brute force O(n * k) did not work in leetcode gave tle.
   public static int numberOfAlternatingGroups1(int[] colors, int k) {
      int ans = 0;
      int n = colors.length;
      int p = 0;
      while(p < n){
         int i = p;
         int j = (i+1) % n;
         int cnt = 2;
         while(colors[i] != colors[j]){
            if(cnt == k){
//               p++;
               ans++;
               cnt = 0;
               break;
            }
//            cnt++;
            i = (i+1)%n;
            j = (j+1) %n;
            if(colors[i] != colors[j]){
               cnt++;
            }
         }
         if(cnt == k){
            ans++;
         }
         p++;
      }
      return ans;
   }

   public static int numberOfAlternatingGroups(int[] colors, int k) {
      int ans = 0;
      int n = colors.length;
      int i = 0;
      int j = i+1;
      int lastVal = colors[i];
      int currCnt = 2;
      while(i < n){
         if(colors[j] == lastVal){
            i++;
            currCnt--;
            if(i == j){
               lastVal = colors[j];
               currCnt++;
               j = (j+1) %n;
            }
         }
         else if(currCnt == k){
            ans++;
            i++;
            lastVal= colors[j];
            j = (j+1) % n;
         }
          else{
            lastVal = colors[j];
            j = (j+1)%n;
            currCnt++;
         }
      }
      return ans;
   }

   public static void main(String[] args) {
      int[] arr = {0, 1,0, 1, 0};
      int[] arr1 = {0,1,0,0,1,0,1};
      int k = 3;
      System.out.println(numberOfAlternatingGroups(arr , k));
      System.out.println(numberOfAlternatingGroups(arr1 , 6));
   }
}
