package maths;
import java.util.*;
public class NthPrime {
    public static int prime(int n){
        int count = 1;
        int i = 3;
        while(count != n){
            if(isPrime(i)) count++;
            i++;
        }
        return i-1;
    }
    public static boolean isPrime(int n){
        if(n==1){
            return false;
        }
        int noOfFactors = 1;
        for(int i = 2 ; i <= n/2 ; i++){
            if(n % i == 0){
                noOfFactors++;
            }
            if(noOfFactors == 2){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(prime(n));
    }
}
