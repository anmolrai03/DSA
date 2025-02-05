package binarysearch.sectionA;

import java.util.Scanner;

public class FindSqrt {
  public static int sqrtN(long N) {
    /*
     * Write your code here
     */

    long s = 1;
    long e = N/2;
    long sqrtVal = -1;
    while (s <= e){
      long m = s + (e-s)/2;
      long sqr = m*m;
      if(sqr == N){
        return (int) m;
      }
      if(sqr > N){
        e = m -1;
      }
      else if(sqr < N){
        sqrtVal = m;
        s = m+1;
      }

    }
    return (int) sqrtVal;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number: ");
    int N = sc.nextInt();
    System.out.println(sqrtN(N));
    System.out.println(Math.sqrt(N));
  }
}
