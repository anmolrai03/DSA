package Arrays;

public class isSorted {

    private static boolean isArraySorted(int[] arr){
        if (arr.length == 0){
            return true;
        }
        if(arr.length == 1){
            return true;
        }

        for(int i = 1 ; i< arr.length ; i++){
            if(arr[i] >= arr[i-1]){
//                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,5,6};
        System.out.println(isArraySorted(arr));
    }
}
