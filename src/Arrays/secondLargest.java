package Arrays;

public class secondLargest {

    private static int largestNum(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return arr[arr.length-1];
        }

        int largest = arr[0];
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    private static int secondLargestNum(int[] arr){
        int largest = largestNum(arr);
        int secondLargest = arr[0];
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] < largest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 2, 4, 7, 7, 5};
        System.out.println(secondLargestNum(arr));
        System.out.println(Integer.MIN_VALUE);
    }
}
