package Leetcode;

import java.util.Scanner;

//March 8;
public class MinimumColors {
   //O(n) brute force.
   public static int minimumRecolors1(String blocks, int k) {
      int lnt = blocks.length();
      if(k > lnt){
         return -1;
      }
      int min = Integer.MAX_VALUE;
      min = isPossible(blocks , k);

      //if k number of B do exists then do this
      if(min == 0){
         return 0;
      }
      min = Integer.MAX_VALUE;

      int i = 0;
      while(i<= (lnt-k)){
         int j = i;
         int cnt = 0;
         while(j-i < k){
            if(blocks.charAt(j)=='W'){
               cnt++;
            }
            j++;
         }
         min = Math.min(cnt , min);
         i++;
      }

      return min;
   }
   private static int isPossible1(String blocks , int k){
      int i = 0;
      int lnt = blocks.length();
      int cnt = 0;
      while(i<lnt){
         if(blocks.charAt(i) == 'W'){
            cnt = 0;
         } else {
            cnt += 1;
            if(cnt == k){
               return 0;
            }
         }
         i++;
      }
      return -1;
   }

   public static int minimumRecolors(String blocks, int k) {
      int lnt = blocks.length();
      if(k > lnt){
         return -1;
      }
      int min = Integer.MAX_VALUE;
      min = isPossible(blocks , k);

      //if k number of B do exists then do this
      if(min == 0){
         return 0;
      }
      min = Integer.MAX_VALUE;

      int i = 0;
      while(i<= (lnt-k)){
         int j = i;
         int cnt = 0;
         while(j-i < k){
            if(blocks.charAt(j)=='W'){
               cnt++;
            }
            j++;
         }
         min = Math.min(cnt , min);
         i++;
      }

      return min;
   }
   private static int isPossible(String blocks , int k){
      int i = 0;
      int lnt = blocks.length();
      int cnt = 0;
      while(i<lnt){
         if(blocks.charAt(i) == 'W'){
            cnt = 0;
         } else {
            cnt += 1;
            if(cnt == k){
               return 0;
            }
         }
         i++;
      }
      return -1;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter string:");
      String blocks = sc.next();
      System.out.println("Enter k:");
      int k = sc.nextInt();
      System.out.println(minimumRecolors(blocks, k));
   }
}
