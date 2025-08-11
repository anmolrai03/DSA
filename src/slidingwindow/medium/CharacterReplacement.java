package slidingwindow.medium;

import java.util.Scanner;

public class CharacterReplacement {
   public static int characterReplacement(String s, int k) {
      int n = s.length();
      int maxLen = 0;

      for(int i = 0; i < n; i++){
         for(int j = i ; j < n; j++){
            if(s.charAt(i) == s.charAt(j)){
//               continue;
            } else{
               if( k <= 0){
                  break;
               } else{
                  k--;
               }
            }
            maxLen= Math.max(maxLen , (j-i)+1);
         }
      }
      return maxLen;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      int k = sc.nextInt();
      System.out.println(characterReplacement(s.toUpperCase() , k));
   }
}
