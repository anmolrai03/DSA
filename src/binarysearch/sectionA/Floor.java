package binarysearch.sectionA;

public class Floor {
    public int floor(int[] arr , int target){
        int s = 0;
        int e = arr.length - 1;
        int floor = 0;
        while(s <= e){
            int m = s + (e-s)/2;
            if(arr[m] <= target){
                floor = arr[m];
                s = m+1;
            }  else {
                e = m-1;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Floor obj = new Floor();
        int[] arr = {3 , 4, 6, 7 , 8 , 9 , 10};
        System.out.println(obj.floor(arr , 8));
    }
}
