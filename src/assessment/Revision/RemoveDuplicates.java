package assessment.Revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RemoveDuplicates {
  public static int removeDuplicates(int[] arr , int n){
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int key : arr){
      map.put(key , map.getOrDefault(key , 0) + 1);
    }

    int length = map.size();

    int i = 0;
    for(int key : map.keySet()){
      arr[i++] = key;
    }

    System.out.println(Arrays.toString(arr));

    return length > 0 ? length : -1;
  }

  //Method 2:
  public static int removeDuplicates1(int[] arr , int n){
    int i = 0;
    int j = i+1;
    while(j < n){
      if(arr[i] == arr[j]){
        j++;
      }
      else{
        swap(arr , ++i , j++);
      }
    }
    System.out.println("swap"+Arrays.toString(arr));
    return i+1;
  }

  private static void swap(int[] arr , int i , int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }


  public static void main(String[] args) {
    int[] arr = {1 ,2, 2, 2, 3};
    int[] arr1 = {1 ,2 ,2, 3, 3, 3, 4 ,4 ,5 ,5};
    System.out.println(removeDuplicates1(arr , arr.length));
    System.out.println(removeDuplicates1(arr1 , arr1.length));
  }
}