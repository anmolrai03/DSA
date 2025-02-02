package binarysearch.sectionA;

public class Ceil {
    public int ceil(int[] arr , int x){
        int s = 0;
        int e = arr.length - 1;
        int ceil = 0;
        while(s <= e){
            int m = s +(e-s)/2;
            if(arr[m] >=x){
                ceil = arr[m];
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return ceil;
    }
    public static void main(String[] args) {
        Ceil obj = new Ceil();
        int[] arr = {3 , 4, 6, 7 , 8 , 9, 10};
        System.out.println(obj.ceil(arr , 2));
    }
}
