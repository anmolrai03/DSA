package Arrays.Medium;
import java.util.*;

public class AlternateNumber {
    public static int[] alternateNumbers(int []a) {
        // Write your code here.
        int n = a.length;
        int[] result = new int[n];
        int posIdx = 0;
        int negIdx = 1;
        for(int i = 0 ; i< a.length ; i++){
            if(a[i] > 0){
                result[posIdx] = a[i];
                posIdx += 2;
            }
            else if(a[i] < 0){
                result[negIdx] = a[i];
                negIdx += 2;
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        int[] a = {1, 2, -4, -5};
        System.out.println(Arrays.toString(alternateNumbers(a)));
    }
}
