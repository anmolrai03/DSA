package Leetcode;

import java.util.HashMap;
import java.util.Scanner;

//March 10: 3306
public class SubstringWithVowelsAndKConsonents {
   public static long countOfSubstrings(String word, int k) {
      int n = word.length();
      if( !word.contains("a") || !word.contains("e") || !word.contains("i") || !word.contains("o") || !word.contains("u")){
         return 0;
      }
      long ans = 0;
      int i = 0;
      int j = 0;
      int cnt = 0;
      HashMap<Character , Integer> map = new HashMap<>();
      while(i < n && j < n){
         char ch = word.charAt(j);
         if(ch == 'a' || ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u'){
            if(map.containsKey(ch)){
               map.put(ch , map.get(ch)+1);
            } else{
               map.put(ch , 1);
            }
            j++;
         }
         else{
            cnt++;
         }
         if(cnt == k && map.size() == 5){
//            j++;
            ans++;
            if( j+1 >= n && i+1 <= n- (k + 5)){
               map.remove(word.charAt(i));
               cnt--;
               i++;
               continue;
            }
            j++;
//               map.remove(word.charAt(i));
//               i++;
//               cnt--;
         }
         else if(cnt > k){
            i = j;
            cnt = 0;
         } else{
            j++;
         }
      }
//      if(map.size() == 5 && cnt == k){
//         ans++;
//      }
      return ans;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      int k = sc.nextInt();
      System.out.println(countOfSubstrings(s , k));
   }
}
