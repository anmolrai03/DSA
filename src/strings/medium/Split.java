package strings.medium;

import java.util.Arrays;
import java.util.Scanner;

public class Split {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String s = sc.nextLine();
      String[] arr = s.split(" ");
      String[] res = new String[arr.length];
      for(String str: arr){
         int pos = str.charAt(str.length()-1) - '0';
         res[pos-1] = str.substring(0 , str.length()-1);
      }
      

      System.out.println(Arrays.toString(res));
   }
}
