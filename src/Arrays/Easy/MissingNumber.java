package Arrays.Easy;

public class MissingNumber {
    public static int missingNumber(int []a, int N) {
        // Write your code here.
        if(N == 0){
            return N;
        }

        //Brute Force.
        //Works only if array is sorted.
        // O(n)

        /*
        for(int i = 0 ; i< N ; i++){
            if(a[i] != i+1){
                return i+1;
            }
        }
        return N+1;
         */
        

        //For any array.
        // O(n^2)

        //Linear search for each number

        /* for(int i = 1 ; i <= N; i++){
            boolean isnumberPresent = false;
            for(int j = 0 ; j < N-1 ; j++){
                if(a[j] == i){
                    isnumberPresent = true;
                    break;
                }
            }
            if(!isnumberPresent){
                return i;
            }
        } */

        //Better approch
        /*Create hash array of last Index as N now mark every number present in given array with a value 1 at the index of the hash array with value of given array i.e index number of hash array is 1 for value present in given array.
         * 
         * Now start to search from index 1 and look for 0 if it is present then that index is missing number
         * 
         * Compelexity is O(n) + O(n)
         */

        /*
        
         
        int[] hashArray = new int[N +1];
        for(int i = 0 ; i < a.length ; i++){
            //Marking presence.
            hashArray[a[i]] = 1;
        }

        //search for unmarked place.
        for(int j = 1 ; j < hashArray.length ; j++){
            if(hashArray[j] == 0){
                return j;
            }
        }

        */

        //Optimal
        /*
            Since Number is in range of 1 to N 
            so sum of array should be N * (N + 1) / 2.
            and the missing number will be requied sum - present sum.
        */ 

        int requiredSum = (N * (N + 1))/2;
        int arraySum = 0;
        for(int i = 0; i < a.length ; i++){
            arraySum += a[i];
        }

        if(requiredSum != arraySum){
            return requiredSum - arraySum;
        }
    
        return N+1;
    }

    public static void main(String[] args) {
        int[] a = {1 ,2 ,3 ,5 ,6 ,7 ,8};
        int N = 8;
        System.out.println(missingNumber(a , N));
    }
}
