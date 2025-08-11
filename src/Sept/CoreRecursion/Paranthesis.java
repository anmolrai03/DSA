package Sept.CoreRecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 22
public class Paranthesis {


   /*
   public static boolean validParanthesis(String str){
      int n = str.length();
      if(n == 0) return true;

      char firstChar = str.charAt(0);
      if(firstChar == ')' || firstChar == '}' || firstChar == ']') return false;

      Stack<Character> st = new Stack<>();
      for(int i = 0; i < n; i++){
         char ch = str.charAt(i);

         if(st.isEmpty()) {
            st.push(ch);
            continue;
         }

         char topEle = st.peek();
         if( ( ch == ')' && topEle == '(' ) || ( ch == '}' && topEle == '{' ) || ( ch == ']' && topEle == '[' ) ){
            st.pop();
         } else {
            st.push(ch);
         }
      }

      return st.isEmpty();
   }

   public static List<String> generateParenthesis(String str){
      List<String> res = new ArrayList<>();
      getParanthesis(str.toCharArray() , 0 , res);
      return res;
   }

   private static void getParanthesis(char[] str , int idx , List<String> ans){
      // base case

      if(idx == str.length){
         String toAdd = new String(str);
         if(validParanthesis(toAdd)){
            ans.add(toAdd);
         }
//         ans.add(toAdd);

         return;
      }

      for(int i = idx; i < str.length; i++){

         if(idx == 0 && str[i] == ')' ) continue;
         // prevent duplicate
         boolean isSkipAble = false;

         for(int j = idx ; j < i ;j++){
            if( str[i] == str[j] ){
               isSkipAble = true;
               break;
            }
         }

         if(isSkipAble) continue;

         swap(str , idx , i);
         getParanthesis(str , idx+1 , ans);
         swap(str , idx , i);
      }
   }

   private static void swap(char[] str , int i , int j){
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;

   }

   */





   public static List<String> generateParenthesis(int n) {
      List<String> ans = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      helper(0 , 0, n , ans , sb);
      return ans;
   }

   private static void helper(int open , int close , int n, List<String> ans , StringBuilder p){
      // base case
      if(open == n && open == close){
         ans.add(p.toString());
         return;
      }

      // recursive case
      if(open < n){
         p.append("(");
         helper(open+1 , close , n , ans , p);
         p.deleteCharAt(p.length()-1);
      }

      if(close < open){
         p.append("(");
         helper(open , close+1 , n , ans , p);
         p.deleteCharAt(p.length()-1);
      }
   }


   public static void main(String[] args) {
//      System.out.println(validParanthesis("()()"));
      for(int i = 1; i <= 8; i++){
         System.out.println(generateParenthesis(i).size());
         System.out.println("-----------------------------------------");
      }
   }
}
