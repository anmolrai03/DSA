package Arrays.Easy;

public class AppearsOnce {
    public static void main(String[] args) {
        int[] arr = {1,1, 2, 3,3, 4,4, 5, 5};
        System.out.println(getSingleElement(arr));
    }

    public static int getSingleElement(int []arr){
        // Write your code here.
        //optimal 
        int XOR = 0;
        for(int i = 0 ; i< arr.length ; i++){
            XOR ^= arr[i];
        }
        return XOR;
    }
}
