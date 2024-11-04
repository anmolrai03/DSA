package Arrays.hard;

public class MaximumProduct {
    public static int subarrayWithMaxProduct(int []arr){
        // Write your code here.
        int maxSub = Integer.MIN_VALUE;
        /*
        for(int i = 0; i<arr.length ; i++){
            int product = 1;
            for(int j = i; j < arr.length ; j++){
                product *= arr[j];
                if(product > maxSub){
                    maxSub = product;
                }
            }
        }
         */
//        int product = 1;
//        for(int i = 0; i<arr.length ; i++){
//            product *= arr[i];
//            maxSub = Math.max(product,maxSub);
//
//            if(product < 1){
//                product = 1;
//            }
//        }

        return maxSub;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 3, -4};
        int[] a1 = {-1 ,3 ,0 ,-4 ,3};
        System.out.println(subarrayWithMaxProduct(a));
        System.out.println(subarrayWithMaxProduct(a1));
    }
}
