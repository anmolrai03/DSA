package recursion.medium;

import java.util.*;

public class GenerateParanthesis {
   public static List<String> generateParenthesis(int n) {

//      return helper(1 , n , new StringBuilder() , 1 , 1);
      return help(n , 0 , 0 , new StringBuilder() );
   }

   private static List<String> help(int n , int f , int b , StringBuilder sb ){


      if(f == n && b == n){
         List<String> res = new ArrayList<>();
         if( sb.equals("")) {
            return res;
         }
         if(isValid(sb.toString())){
            res.add(sb.toString());
         }
         return res;
      }

      // check all the position in can add
      List<String> frontAdd = new ArrayList<>();
      List<String> backAdd = new ArrayList<>();

      // front adding
      if(f != n){
         for(int i = 0; i <= sb.length(); i++){
            sb.insert(i , "(");
            frontAdd = help(n , f+1  , b, sb);
            sb.deleteCharAt(i);
         }
      }

      // back adding
      if( b != n){
         for(int i = 0; i <= sb.length(); i++ ){
            sb.insert(i , ")");
            backAdd = help(n , f, b + 1 , sb);
            sb.deleteCharAt(i);
         }
      }

      frontAdd.addAll(backAdd);

      return frontAdd;
   }


   private static boolean isValid(String s) {

      int n = s.length();
      if( n == 0) return false;

      HashMap<Character , Character> map = new HashMap<>();
      map.put(')' , '(');
      map.put('}' , '{');
      map.put(']' , '[');

      Stack<Character> st = new Stack<>();

      for(int i = 0; i < n; i++){
         char ch = s.charAt(i);
         if(map.containsKey(ch) ){
            if(!st.isEmpty() && st.peek() == map.get(ch) ) {
               st.pop();
            } else {
               return false;
            }

         } else {
            st.push(ch);
         }
      }
      return st.isEmpty();
   }


   public static void main(String[] args) {
      System.out.println(generateParenthesis(3));
   }
}
