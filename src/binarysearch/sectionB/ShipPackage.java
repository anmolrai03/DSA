package binarysearch.sectionB;

public class ShipPackage {

  public static int leastWeightCapacity(int[] weights, int d) {
    // Write your code here.
    int s = maxEle(weights);
    int e = sum(weights);
    System.out.println(s+" "+ e);
    int res = -1;
    while (s <= e){
      int m = s + (e -s )/2;
      int daysRequired = daysCal(weights,m);
      if(daysRequired <= d){
        res = m;

        //since daysRequired is under the days given so we may consider using less capacity to
        // find the least capacity. so end = mid -1 ; moving toward the smaller capacity range.
        e = m -1;
      } else {
        s = m + 1;
      }
    }
    return res;
  }

  private static int maxEle(int[] arr){
    int max = arr[0];
    for(int num: arr){
      if(num >max){
        max = num;
      }
    }
    return max;
  }

  private static int sum(int[] arr){
    int sum = 0;
    for(int num: arr){
      sum += num;
    }
    return sum;
  }

  private static int daysCal(int[] arr , int capacity){
    int currentDay = 1; int load = 0;
    for(int num : arr){
      if(load + num > capacity){
        currentDay++;
        load = num;
      } else {
        load += num;
      }
    }
    return currentDay;
  }

  public static void main(String[] args) {
    int[] weight =  {1,2,3,4,5,6,7,8,9,10};
    int[] weight1 =  {5,4,5,2,3,4,5,6};
    int days = 1;
    System.out.println(leastWeightCapacity(weight,days));
    System.out.println(leastWeightCapacity(weight1,5));
  }

}
