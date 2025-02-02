package strings;

import java.util.Arrays;

public class ReverseWord{

    private static void reverseArr(String[] arr){
        int left = 0, right = arr.length - 1;
        while( left<= right){
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        String[] words = s.split(" ");
        reverseArr(words);
        String ans = "";
        for(String word: words){
            ans += (word + " ");
        }
        return ans.trim();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("the sky is blue"));
    }
}