package Arrays;

public class RemoveDuplicate {
    private static void swap(int[] arr , int f , int s){
        int temp = arr[f];
        arr[f] = arr[s];
        arr[s] = temp;
    }

    public static int removeDuplicates(int[] arr,int n) {
        if(n== 0 || n == 1){
            return n;
        }

        int i = 0;
        int j = 1;
        while(j != n){
            if(arr[j] != arr[i]){
                swap(arr, ++i, j++);
            }
            else{
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 2, 2, 3};
        int[] arr = {1,1, 1, 2, 3, 3, 4, 5, 5, 5};
        System.out.println(removeDuplicates(arr , arr.length));
    }
}
