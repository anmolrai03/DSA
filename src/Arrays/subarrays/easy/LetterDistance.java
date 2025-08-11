package Arrays.subarrays.easy;

import java.util.HashMap;

public class LetterDistance {
   public static boolean checkDistances(String s, int[] distance) {
      HashMap<Character , Integer> map = new HashMap<>();
      int n = s.length();

      for(int i =0; i < n; i++){
         if(!map.containsKey(s.charAt(i))){
            map.put(s.charAt(i) , i);
         }
      }
//      System.out.println(map);

      for(int i = 0; i < 26; i++){

         char key = (char) ('a' + i);
         if(!map.containsKey(key)){
            continue;
         }
         int startIdx = map.get(key);
         int tocheckIdx = startIdx+distance[i] + 1;

         if(tocheckIdx >= n) return false;

         if(!(s.charAt(tocheckIdx) == key)){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      System.out.println(checkDistances("abaccb" , new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
      System.out.println(checkDistances("aa" , new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
          ,0,0,0,0,0}));
//      HashMap<Character , Integer> map = new HashMap<>();
//      map.put('a' , 0);
//      map.put('b' , 3);
//      System.out.println(map.get('a'));
//      System.out.println(map.get( (char) ('a' + 0)));
//      System.out.println(map.get( (char) ('a' + 1)));
//      int idx = map.get('c');
//      System.out.println(map.get('c'));
//      System.out.println(idx);
   }
}
