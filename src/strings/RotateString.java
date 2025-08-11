package strings;

import java.util.Scanner;

public class RotateString {
   public static boolean rotateString(String s, String goal) {
      int lnt = s.length();
      int size = goal.length();

      if(lnt != size){
         return false;
      }
      char search = s.charAt(0);
      int idx = findChar(goal , search);
      System.out.println(idx);
      if(idx == -1) return false;



      int i = 0;
      int j = idx;
      while(i<lnt){
         if(s.charAt(i) == goal.charAt(j%size)){
            i++;
            j++;
         } else {
            return false;
         }
      }
      return true;
   }
   private static int findChar(String name , char ch){
      for(int i = 0 ; i < name.length() ; i++){
         if(name.charAt(i) == ch){
            return i;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter s:");
      String s = sc.next();
      System.out.println("enter goal:");
      String goal = sc.next();

      System.out.println(rotateString(s , goal));
   }
}
