package Leetcode;

public class FruitBasket2 {
   public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
      int output = 0;
      for(int fruit: fruits){
         boolean basketFound = false;
         for(int basket: baskets){
            if(basket == -1) continue;
            if(fruit <= basket){
               basketFound = true;
               basket = -1;
               break;
            }

         }

         if(!basketFound){
            output++;
         }
      }
      return output;
   }

   public static void main(String[] args) {
      int[] fruits = {4,2,5};int[] baskets = {3, 5, 4};
      System.out.println(numOfUnplacedFruits(fruits, baskets));
   }
}
