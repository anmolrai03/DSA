package strings.medium;

import java.util.*;

public class NotinBothChar {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s1 = sc.next();
      String s2 = sc.next();
      System.out.println(notinBoth(s1 , s2));
   }

   static String notinBoth(String a , String b){
      String res = "";
      int alen = a.length(); int blen = b.length();
      if(alen == 0) return b; if(blen == 0) return a;

      StringBuilder sb = new StringBuilder();

      HashSet<Character> sta = new HashSet<>();
      HashSet<Character> stb = new HashSet<>();

      //iterate in a and put them in sta
      for(int i = 0; i< alen ; i++){
         sta.add(a.charAt(i));
      }

      //iterate in b and put them in stb
      for(int i = 0; i < blen ; i++){
         stb.add(b.charAt(i));
      }

      //check for elements of b not present in sta
      for(Character ch: stb){
         if( !sta.contains(ch)){
            sb.append(ch);
         }
      }

      //check for elements of a not present in stb
      for(Character ch: sta){
         if( !stb.contains(ch)){
            sb.append(ch);
         }
      }

      res = sb.toString();
      char[] chars = res.toCharArray();
      Arrays.sort(chars);
      sb.delete(0 , sb.length());
      for(char ch : chars){
         sb.append(ch);
      }

      return sb.toString();
   }
}
