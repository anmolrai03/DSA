package recursion.basic;

public class SubsetPartiton {
   static boolean subsetPartition(int[] arr , int target , int n){
      //base condition.
      if(target == 0) return true;
      if(n == 0) return false;

      //recursive conditon.
      if(target >= arr[n-1]){
         return subsetPartition(arr , target - arr[n-1] , n-1) || subsetPartition(arr , target ,
             n-1);
      }
      return subsetPartition(arr , target ,
          n-1);
   }

   static boolean equalPartition(int[] arr , int n){
      int sum = 0;
      for(int num: arr){
         sum += num;
      }
      if(sum % 2 != 0) return false;
      return subsetPartition(arr , sum/2 , n);
   }

   public static void main(String[] args) {
//      int [] arr = { 2 , 3 , 4 , 5 ,1};
      int [] arr = { 2 , 3 , 4 , 6 ,1};
//      System.out.println(subsetPartition(arr , 11 , 5));
      System.out.println(equalPartition(arr , 5));

   }
}
