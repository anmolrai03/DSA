package maths;

public class Armstrong {
    private static boolean isArmstrong(int n){
        //No of digits
        int noOfDigits = (int) Math.log10(n) + 1;
        int sum = 0;
        int check = n;

        while (n > 0){
            int digits = n % 10;
            sum += Math.pow(digits,noOfDigits);
            n /= 10;
        }
        return sum == check;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(1634));
    }
    
}
