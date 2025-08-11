public class BinarySearch {
  
  static int binarySearch(int[] arr , int s , int e , int target){
    if( s > e){
      return -1;
    }

    int m = s + (e -s)/2;
    if(arr[m] == target){
      return m;
    }

    if(target > arr[m]){
      return binarySearch(arr, m+1, e, target);
    }

    return binarySearch(arr, s, m-1, target);
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    System.out.println(binarySearch(arr, 0, arr.length-1, 2));
  }
}
