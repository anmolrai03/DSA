package maths;

public class CountDigits {
    public static int countDigits(int n){
        // Write your code here.
        int temp = n;
        int numberOfDigitsThatDivide = 0;
        //extract digits
        while (n > 0){
            int digit = n % 10;

            //check if digits divids n
            if(digit > 0 && temp % digit == 0){
                numberOfDigitsThatDivide++;
            }
            n /= 10;
        }
        return numberOfDigitsThatDivide;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(660));
    }
}
