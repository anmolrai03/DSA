package strings.medium;

public class PalindromicSubString {
   public static String longestPalindrome(String s){

      int n = s.length();
      int l = 0;
      int r = n-1;
      int len = 0;
      StringBuilder ans = new StringBuilder();

      while(l <= r){
         //  String curr = s.substring(l , r+1);
         if(isPalindrome(s , l , r)){
            if(len < r-l+1) {
               ans.setLength(0);
               ans.append(s.substring(l , r+1));
               len = r - l + 1;
               break;
            }
         }
         r--;
      }
      l = 0;
      r = s.length()-1;
      while(l <= r){
         //  String curr = s.substring(l , r+1);
         if(isPalindrome(s , l , r)){
            if(len < r-l+1) {
               ans.setLength(0);
               ans.append(s.substring(l , r+1));
               len = r - l + 1;
               break;
            }
         }
         l++;
      }

      return ans.toString();
   }

   private static boolean isPalindrome(String s, int st , int end){
      int i = st;
      int j = end;
      while(i <= j){
         if(! (s.charAt(i) == s.charAt(j)) ){
            return false;
         }
         i++;
         j--;
      }
      return true;
   }

   public static void main(String[] args) {
//      System.out.println(isPalindrome("aaa"));
//      System.out.println(isPalindrome("caa"));
      System.out.println(longestPalindrome("cbbd"));
   }


}
