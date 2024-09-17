package Arrays.Easy;

public class MaxConsiOnes {
    public static void main(String[] args) {
        int [] arr = {1,1,1, 0 , 0 , 0 , 1, 0 , 0 , 1, 1,1,1};
        System.out.println(consecutiveOnes(arr.length, arr));
    }

    public static int consecutiveOnes(int n, int[] arr) {
		// Write your code here.
        int maxi = 0;
        int i = 0;
        int count = 0;
        while(i<n){
            if(arr[i] == 1){
                count++;
                if(count > maxi ){
                    maxi = count;
                }
            } else {
                count = 0;
            }
            i++;
        }
        
        return maxi;
	}
}
