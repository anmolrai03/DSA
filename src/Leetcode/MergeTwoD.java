package Leetcode;

import java.util.Arrays;

public class MergeTwoD {

   private static int findRequiredLength(int[][] a, int[][] b){
      int m = a.length;
      int n = b.length;
      int i = 0;
      int j = 0;
      int lnt = 0;

      while(i < m && j < n){
         lnt++;
         if(a[i][0] == b[j][0]){
            i++;
            j++;
         } else if(a[i][0] < b[j][0]){
            i++;
         } else {
            j++;
         }
      }
      //if array a remains
      while( i< m){
         lnt++;
         i++;
      }
      while(j < n){
         lnt++;
         j++;
      }
      return lnt;
   }

   public  static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
      int num1length = nums1.length;
      int num2length = nums2.length;

      int lengthRequired = findRequiredLength(nums1,nums2);

      int[][] ans = new int[lengthRequired][2];
      int i = 0;
      int j = 0;
      int k = 0;

      while(i < num1length && j < num2length){
         if(nums1[i][0] == nums2[j][0]){
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1] + nums2[j][1];
            i++;
            j++;
         } else if(nums1[i][0] < nums2[j][0]){
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            i++;

         } else {
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            j++;
         }
         k++;
      }

      while(i < num1length){
         ans[k][0] = nums1[i][0];
         ans[k][1] = nums1[i][1];
         i++;
         k++;
      }

      while (j < num2length){
         ans[k][0] = nums2[j][0];
         ans[k][1] = nums2[j][1];
         j++;
         k++;
      }
//
//      for(int[] num: ans){
//         if(num[0] == 0 && num[1] == 0){
//
//         }
//      }

      return ans;
   }

   public static void main(String[] args) {
//      int[][] arr = {{1, 2}, {2, 3}, {4, 5}};
//      int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};

      int[][] nums1 = {{148, 597}, {165, 623}, {306, 359}, {349, 566}, {403, 646}, {420, 381}, {566, 543}, {730
          , 209}, {757, 875}, {788, 208}, {932, 695}};

      int[][] nums2 = {{74, 669}, {87, 399},{89, 165},{99, 749},{122, 401},{138, 16},{144, 714},{
      148, 206}
      ,{177, 948},{211, 653},{285, 775},{309, 289},{349, 396},{386, 831},{403, 318},{405, 119},{
      420, 153},{468, 433},{504, 101},{566, 128},{603, 688},{618, 628},{622, 586},{641, 46},{
      653, 922},{672, 772},{691, 823},{693, 900},{756, 878},{757, 952},{770, 795},{806, 118},{
      813, 88},{919, 501},{935, 253},{982, 385}};

      int[][] ans = mergeArrays(nums1 , nums2);
      for(int[] num : ans){
         System.out.println(Arrays.toString(num));
      }
//      System.out.println(findRequiredLength(nums1 , nums2));
//      System.out.println(Arrays.toString(mergeArrays(arr , arr1)));
   }
}
