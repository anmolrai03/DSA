package binarysearch.sectionA;

import java.util.Scanner;

public class NthRoot {

  public static int nthRoot(int n, int m) {
    // Write your code here.
    int start = 1;
    int end = m;
    while (start <= end){
      int mid = start + (end - start)/2;
      long number =1;
      for(int i = 1 ; i <= n ; i++){
        number *= mid;
        if(number > m || number < 0){
          break;
        }
      }
      if(number == m){
        return mid;
      }
      if(number > m){
        end = mid - 1;
      } else{
        start = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int m = sc.nextInt();
    System.out.println(nthRoot(n,m));
  }
}

