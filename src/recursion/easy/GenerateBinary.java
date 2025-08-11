package recursion.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateBinary {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
//      System.out.println(toBinary(n));
      System.out.println(generateBinaryNumbers(n));
   }

   private static String toBinary(int num){
      String ans = "";
      while(num >= 1){
         int rem = num % 2;
         ans = rem + ans;
         num = num /2;
      }
      return ans;
   }

   private static List<String> generateBinaryNumbers(int n){
      List<String> list = new ArrayList<>();
      if(n == 1){
         list.add("1");
         return list;
      }
      String binary = toBinary(n);
      List<String> li = generateBinaryNumbers(n-1);
      list.addAll(li);
      list.add(binary);
      return list;
   }
}
