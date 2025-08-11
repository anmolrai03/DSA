package binarysearch.sectionA;

public class PeakElement {

  public static int peak(int[] arr){

    // O(n): Using breakpoint method.
    int n = arr.length;
    for(int i = 0 ; i < n - 1; i++){
      if( arr[i] > arr[i+1]){
        return i;
      }
    }
    return arr.length-1;
  }

  public static void main(String[] args) {
    int[] arr = {3,4,5,1,2};
    int[] arr1 = {2, 3 ,4 ,1};
    int[] arr2 = {1, 2, 3, 5};
    System.out.println(peak(arr));
    System.out.println(peak(arr1));
    System.out.println(peak(arr2));
  }

}
