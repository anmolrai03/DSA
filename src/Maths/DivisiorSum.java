package maths;

public class DivisiorSum {
    private static int sumOfDivisors(int n){
        int sum = 0;
        for(int i = 1 ; i < n/2; i++){
            if(n % i == 0){
                sum = sum + i + (n/i);
            }
        }
        return sum;
    }

    public static int sumOfAllDivisors(int n){
        // Write your code here.
        int sum = 0;
        for (int i = 1 ; i <= n ; i++){
            sum += sumOfDivisors(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfAllDivisors(5));
    }
}
