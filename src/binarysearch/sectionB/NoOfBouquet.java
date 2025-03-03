package binarysearch.sectionB;

import java.util.Arrays;

public class NoOfBouquet {

  public static boolean possible(int[] arr , int day , int r , int b){

    int nob = 0;
    int count = 0;
    for(int num : arr){
      if(num <= day){
        count++;
      } else {
        nob += (count/r);
        count = 0;
      }
    }
    nob += (count/r);
    if(nob >= b) return true;
    return false;

  }
  //b = no of required bouquet , r = no of roses/bouquet.
  public static int roseGarden(int[] arr, int r, int b) {
    // Write your code here.
    int res[] = minMaxEle(arr);
    System.out.println(Arrays.toString(res));
    int s = res[0];
    int e = res[1];
    System.out.println(Arrays.toString(arr));

    //Minimum number of days required.
    int nod = -1;

    //binary search
    while (s <= e)
    {
      int m = s + (e - s)/2;
      int nob = 0;
      int count = 0;

      //Counting the number of bouquet that can be formed on that day (nob);
      for(int num : arr){
        if(num <= m){
          count++;
        } else {
          nob += (count/r);
          count = 0;
        }
      }
      nob += (count/r);

      //cheking the result received.
      if(nob >= b){
        //if current number of bouquet is more than or equal to number of bouquet required it
        // means that we need to reduce the number of days , i.e, m to get the minimum number of
        // days required. so e = m -1 ;
        nod = m;
        e = m-1;
      } else {
        s = m + 1;
      }

    }
    return nod;
  }

  //minEle
  static int[] minMaxEle(int [] arr){
    int[] temp = Arrays.copyOf(arr , arr.length);
    Arrays.sort(temp);
    return new int[]{temp[0], temp[temp.length - 1]};
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 1, 2, 7, 2, 2, 3, 1 };
    int[] arr1 = {1,1, 1, 1 };
    int arr2[] = {7, 7, 7, 7, 13, 11, 12, 7};
    int arr3[] = {1,10,3,10,2};
    System.out.println(roseGarden(arr , 3 , 2));
    System.out.println(roseGarden(arr1 , 1 , 1));
    System.out.println(roseGarden(arr2 , 3 , 2));
    System.out.println(roseGarden(arr3 , 1 , 3));
  }
}
