package Leetcode.contest.constest3;

import java.util.*;

public class MinimumDeletion {
   public static void main(String[] args) {
      HashMap<Character , Integer> map = new HashMap<>();
      map.put('a' , 3);
      map.put('b' , 10);

      Comparator<Integer> com = (i , j) -> i>j ? 1 : -1;

//      System.out.println(map.values());
      System.out.println(minDeletion("fgcww" , 2));
   }


   public static int minDeletion(String s, int k) {
      HashMap<Character , Integer> map = new HashMap<>();
      for(int i = 0; i < s.length(); i++){
         map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
      }
      if(k == map.size()){
         return 0;
      }

      List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
      entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
      System.out.println(entryList);

      System.out.println(map.values());


      int min = 0;
      for(Map.Entry<Character , Integer> entry : entryList){
//         min += entry.getValue();
         if(k == 0){
            min += entry.getValue();
         } else{
            k--;
         }
      }
      return min;
   }
}
