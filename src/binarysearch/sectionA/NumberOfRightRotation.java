package binarysearch.sectionA;

import static binarysearch.sectionA.PeakElement.peak;

public class NumberOfRightRotation {
  static int rightRotation(int[] arr){
    int n = arr.length;
    int peak = peak(arr);
    int numberOfRotation = (peak + 1) % n;
    return numberOfRotation;
  }

  public static void main(String[] args) {
    int[] arr = {3,4,5,1,2};
    int[] arr1 = {2, 3 ,4 ,1};
    int[] arr2 = {1, 2, 3, 5};
    System.out.println(rightRotation(arr));
    System.out.println(rightRotation(arr1));
    System.out.println(rightRotation(arr2));
  }
}
