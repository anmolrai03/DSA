package Leetcode;
import java.util.*;

/*
1128. Number of Equivalent Domino Pairs
 */

public class Dominoes {
   public static int numEquivDominoPairs1(int[][] dominoes) {

      HashMap<List<Integer>, Integer> map = new HashMap<>();
      for(int[] num: dominoes){

         List<Integer> key = new ArrayList<>();
         key.add(num[0]);
         key.add(num[1]);
         List<Integer> probkey = new ArrayList<>();
         probkey.add(num[1]);
         probkey.add(num[0]);

         if(map.containsKey(key) || map.containsKey(probkey)){
            map.put(key , map.get(key)+1);
         } else{
            map.put(key, 1);
         }

         // map.put(key , map.getOrDefault((key || probKey) , 0)+1);
      }

      System.out.println(map.toString());

      int pairCount = 0;
      for(Map.Entry<List<Integer> , Integer> entry: map.entrySet()){
         int val = entry.getValue();
         int calcPair = val * (val -1 )/2;
         pairCount += calcPair;
      }

      return pairCount;


//      Collections.sort(dominoes);
//      Comparator<int[]> com = (i , j)-> Integer.compare(i[0] , j[0]);
//      Comparator<int[]> com = Comparator.comparingInt(i -> i[0]);
//      Comparator<int[]> com2 = Comparator.comparingInt(i -> i[1]);
////      Comparator<int[][] >
//      Arrays.sort(dominoes, com);
//      Arrays.sort(dominoes, com2);
//      for(int[] num : dominoes){
//         System.out.print(Arrays.toString(num) +" ");
//      }
//
//      int numberOfTypes = 1;
//      int paircont = 0;
//      int n = dominoes.length;
//      for(int i = 0; i< n-1; i++){
//         if(isEqual(dominoes , i)){
//            numberOfTypes++;
//         }
//      }
//      paircont = numberOfTypes * (numberOfTypes-1) /2;
//      return paircont;
   }

   public static int numEquivDominoPairs2(int[][] dominoes) {

      HashMap<int[], Integer> map = new HashMap<>();

      for(int[] d: dominoes){

         int[] key = new int[]{d[0] , d[1]};
         int[] revKey = new int[]{d[1] , d[0]};

         if(map.containsKey(key)){
            map.replace(key , map.get(key)+1);
         }
         else if(map.containsKey(revKey)){
            map.replace(revKey, map.get(revKey)+1 );
         }
         else{
            map.put(d , 1);
         }
      }

      System.out.println(map.toString());

      int pairCount = 0;
      for(Map.Entry<int[] , Integer> entry: map.entrySet()){
         int val = entry.getValue();
         int calcPair = val * (val -1 )/2;
         pairCount += calcPair;
      }

      return pairCount;

   }

   public static int numEquivDominoPairs3(int[][] dominoes){

      HashMap< List<Integer> , Integer > map = new HashMap<>();
      for(int[] domino: dominoes){

         List<Integer> key = new ArrayList<>(Arrays.asList(domino[0] , domino[1]));
         List<Integer> revKey = new ArrayList<>(Arrays.asList(domino[1] , domino[0]));

//         map.put(key , map.getOrDefault(key , 0)+1);
//         map.put(revKey , map.getOrDefault(revKey , 0)+1);

         if(map.containsKey(key)){
            int val = map.get(key);
            map.replace(key , val+1);
//            if(val >= 1){
//               map.replace(key , val*2 + val);
//            } else{
//               map.replace(key , val+1);
//            }
         }
         else if(map.containsKey(revKey)){
            int val = map.get(revKey);
            map.replace(revKey , val+1);
//            if(val >= 1){
//               map.replace(revKey , val*2 + val);
//            }else{
//               map.replace(revKey , val+1);
//            }
         }
         else{
            map.put(key , 1);
         }
      }

      System.out.println(map);
      int pairs = 0;
      for(Map.Entry<List<Integer> , Integer> entry: map.entrySet()){
         int val = entry.getValue();
         int calPair = val *( val-1) /2;
         pairs += calPair;
      }
      return pairs;

   }

   public static int numEquivDominoPairs(int[][] dominoes) {
      HashMap<int[], Integer> map = new HashMap<>();

      for (int[] domino : dominoes) {
         int[] rev = {domino[1], domino[0]};

         if (map.containsKey(domino)) {
            map.replace(domino, map.get(domino) + 1);
         } else if (map.containsKey(rev)) {
            map.replace(rev, map.get(rev) + 1);
         } else {
            map.put(domino, 1);
         }
      }
      int pairs = 0;
      for (Map.Entry<int[], Integer> entry : map.entrySet()) {
         int val = entry.getValue();
         int calPair = val * (val - 1) / 2;
         pairs += calPair;
      }
      return pairs;
   }

   private static boolean isEqual(int[][] d , int i){
      return ( (d[i][0] == d[i+1][0] ) && (d[i][1] == d[i+1][1]) ) || ( (d[i][0] == d[i+1][1]) && (d[i][1] == d[i+1][0]) );
   }


   public static void main(String[] args) {
      int[][] d = {{1,2},{1,2},{1,1},{1,2},{2,2}};
      int[][] d1 ={{1,2},{2,1},{3,4},{5,6}};
      int[][] d2 ={{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
      int[][] d3 = {{2,1},{1,2},{1,2},{1,2},{2,1},{1,1},{1,2},{2,2}};
      System.out.println(numEquivDominoPairs(d));
      System.out.println(numEquivDominoPairs(d1));
      System.out.println(numEquivDominoPairs(d2));
      System.out.println(numEquivDominoPairs(d3));
//      System.out.println(numEquivDominoPairs(d1));
//      int[] arr = {1, 3};
//      List<Integer> list = new ArrayList<>(Arrays.asList(arr[0] , arr[1]));
//      System.out.println(list);
   }
}
