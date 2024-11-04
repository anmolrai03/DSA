package Arrays.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class Alpha {

    public static boolean findAlgoName(String first , String second){
        HashSet<Character> st =  new HashSet<>();

        for(int i = 0 ; i < first.length(); i++){
            st.add(first.charAt(i));
        }
        for(int i = 0 ; i < second.length(); i++){
            st.add(second.charAt(i));
        }
        for(char i = 'a' ; i< 'z'; i++){
            if(!st.contains(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();


        System.out.println(findAlgoName(first , second));
    }
}
