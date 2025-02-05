package binarysearch.sectionB;

import java.util.Arrays;

public class KokoBanana {
  static int numberOfBanana(int n , int[] a , int h){

    //Find the Max number of Banana Koko can eat in an hour.
    int maxEle = maxEle(a);
//    System.out.println(maxEle);

    //Binary Search in range 1 to maxEle.
    int s = 1;
    int e = maxEle;
    while(s <= e){
      int m = s + (e - s)/2;

      //Calculate total sum of hours required if the pace is m banana/hr.
      long sumHrs = 0;
      for(int num: a){
//        sumHrs += Math.ceilDivision(num , m);
        sumHrs += ceilDivision(num , m);
      }

      //Proceed to eliminate one half;.
      if(sumHrs <= h){
        //less pace is required. to increase sumHrs close to given h.
        e = m -1;
      } else{
        //more pace is requried , to decrease the sumHrs close to given h.
        s = m + 1;

      }
    }
    return s;
  }

  static int maxEle(int[] a){
    Arrays.sort(a);
    int n = a.length;
    return a[n-1];
  }

  static int ceilDivision(int n , int m){
    if(n%m == 0){
      return n/m;
    } else {
      return n/m +1;
    }
  }


  public static void main(String[] args) {
    int[] a = {25, 12, 8, 14, 19};
    int n = 5;
    int h = 5;
    int n1 = 4; int a1[] = {7, 15, 6, 3}; int h1 = 8;
    int a2[] = {4 ,9 ,4 ,3 ,1 ,3};int n2 = a2.length; int h2 = 66;
    int a3[] = {805306368, 805306368 ,805306368};int n3 = a3.length; int h3 = 1000000000;
    System.out.println(numberOfBanana(n , a , h));
    System.out.println(numberOfBanana(n1 , a1 , h1));
    System.out.println(numberOfBanana(n2 , a2 , h2));
//    System.out.println(ceilDivision(3,6));
//    System.out.println(ceilDivision(6,6));
//    System.out.println((3/6));
//    System.out.println(Math.ceilDivision(3,6));
    System.out.println(numberOfBanana(n3 , a3 , h3));
  }
}
