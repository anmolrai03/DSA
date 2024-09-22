package maths;

public class Palindrome {
    public static boolean palindromeNumber(int n){
        // Write your code here.

        //Two pointer approch for O(n/2);
        String str = Integer.toString(n);
        int right = 0 ; 
        int left = str.length() - 1;

        while (right <= left){
            if(str.charAt(right) == str.charAt(left)){
                right++;
                left--;
            } else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromeNumber(1032));
    }
}
