package slidingwindow.medium;

public class MaxPoints {
   public static int maxScore(int[] cardPoints, int k) {
      int n = cardPoints.length;
      if(k == 0){
         return 0;
      }

      int sum = 0;
      if( k > n){
         for(int num: cardPoints){
            sum += num;
         }
         return sum;
      }

      int s = 0; int e = n-1;
      int cnt =0;
      while(s < n && e >= 0 && cnt != k){

         if(cardPoints[s] == cardPoints[e]){
            sum+= cardPoints[s];
            s++;
         }
         else if(cardPoints[s] > cardPoints[e]){
            sum += cardPoints[s];
            s++;
         }
         else{
            sum += cardPoints[e];
            e--;
         }
         cnt++;
      }
      return sum;
   }

   public static void main(String[] args) {
//      int[] arr1 = {100,40,17,9,73,75};
//      int[] arr2 = {1,2,3,4,5,6,1};
//      int[] arr = {9,7,7,9,7,7,9};
      int[] arr3 = {1,79,80,1,1,1,200,1};
      System.out.println(maxScore(arr3 , 3));
//      System.out.println(maxScore(arr1 , 3));
//      System.out.println(maxScore(arr2 , 2));
//      System.out.println(maxScore(arr , 7));
   }
}
