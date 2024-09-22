package maths;
import java.util.*;
public class SumOfFactors {
    public static int sumOfFactors(int n) {
        // Write your code here
        int sum = 0;
        if(n == 1){
            return n;
        }
        for(int i = 2; i *i <= n ; i++){
            if(n % i ==0){
                sum = sum +i;
                if(n/i != i){
                    sum += n/i;
                }
            }
        }
        sum = sum + 1+n;
        return sum;
    }

    public static List<Integer> factors(int n){
        List<Integer> list = new ArrayList<>();
        if(n == 1){
            list.add(1);
            return list;
        }
        for(int i = 2 ; i * i <= n; i++){
            if(n % i == 0){
                list.add(i);
                if(n/i != i ){
                    list.add(n/i);
                }
            }
        }
        list.add(1);
        list.add(n);
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        int n = 10;
        // System.out.println(sumOfFactors(n));
        // System.out.println(21 % 1);
        // System.out.println(21 / 1);
        // System.out.println(Math.sqrt(21));
        System.out.println(factors(n)+" : " +sumOfFactors(n));
        
    }
    
}
