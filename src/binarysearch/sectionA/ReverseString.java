package binarysearch.sectionA;

public class ReverseString {
    public static boolean isVowel(char ch){

        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' || ch == 'U';
    }

    public static String reverseVowels(String s) {
        int strt = 0 ;
        int e = s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while( strt <=e ){
            while(!isVowel(sb.charAt(strt))){
                strt++;
            }
            while(!isVowel(sb.charAt(e))){
                e--;
            }
            if(strt <= e){
                char temp = sb.charAt(strt);
                sb.setCharAt(strt , sb.charAt(e));
                sb.setCharAt(e , temp);
                strt++;
                e--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }
}
