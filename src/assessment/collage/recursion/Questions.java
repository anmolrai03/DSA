package assessment.collage.recursion;

import java.util.ArrayList;

public class Questions {
   public static void main(String[] args) {
      String s= "abc";
//      String ans = removeA(s , 0 , "");
//      System.out.println(ans);
//      skipA("" , s);
//      System.out.println(skipA( s));

      subSequenceVoid("" , s);
      ArrayList<String> ans = subSequence("" , s);
      System.out.println(ans);
      ans = subSeq("" , s , new ArrayList<>());
      System.out.println(ans);
   }

   //Subsequence.
   static void subSequenceVoid(String p , String up){
      //base condition
      if(up.isEmpty()){
         System.out.println(p);
         return;
      }

      //recurive calls.
      char ch = up.charAt(0);
      subSequenceVoid(p , up.substring(1));
      subSequenceVoid(p + ch , up.substring((1)));
   }

   static ArrayList<String> subSequence(String p , String up){


      //base condition
      if(up.isEmpty()){
         ArrayList<String> list = new ArrayList<>();
         list.add(p);
         return list;
      }

      //recurive calls.
      char ch = up.charAt(0);
      ArrayList<String> left = subSequence(p , up.substring(1));
      ArrayList<String> right = subSequence(p + ch , up.substring((1)));

      left.addAll(right);
      return  left;
   }

   static ArrayList<String> subSeq(String p , String up , ArrayList<String> list){
      //base condition
      if(up.isEmpty()){
         list.add(p);
         return list;
      }

      char ch = up.charAt(0);
      //recursive calls.
      subSeq(p + ch , up.substring(1) , list);
      subSeq(p , up.substring(1) , list);

      return list;
   }

   //Remove all the 'a'.
   static String removeA(String s ,int idx, String ans){

      //base condition.
      if(idx == s.length()){
         return ans;
      }
      //Recursive condition
      char ch = s.charAt(idx);
      if(ch != 'a'){
         ans += ch;
      }
      return removeA(s , idx + 1 , ans);

   }

   static void skipA(String p , String up){

      //base condition.
      if(up.isEmpty()){
         System.out.println(p);
         return;
      }

      //recursive condition.
      char ch = up.charAt(0);
      if(ch == 'a'){
         skipA(p , up.substring(1));
      } else {
         skipA(p + ch , up.substring(1));
      }
   }

   static String skipA(String up){

      //base condition.
      if(up.isEmpty()){
         return "";
      }

      //recursive condition.
      char ch = up.charAt(0);
      if(ch == 'a'){
         return skipA(up.substring(1));
      } else {
         return ch + skipA(up.substring(1));
      }
   }


}
