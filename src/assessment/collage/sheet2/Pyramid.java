package assessment.collage.sheet2;

import java.util.Scanner;

public class Pyramid {
   public static void printPyramid(int n){
      for(int i = 1;i<=n;i++){
         for(int j = 1;j<=(n-i);j++){
            System.out.print("  ");
         }
         int out = i;
         for(int k = 1;k<=i;k++){
            System.out.print(out+" ");
            if(k == i){
               out--;
               continue;
            }
            out++;
         }
         for(int k =1;k<i;k++){
            System.out.print(out+" ");
            out--;
         }
         System.out.println();
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      printPyramid(n);
   }
}
