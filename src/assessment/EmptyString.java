import java.util.Scanner;

public class EmptyString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Number of test cases
        int T = sc.nextInt();
        
        while (T > 0) {
            // Length of the string
            int N = sc.nextInt();
            
            // The binary string
            String S = sc.next();
            
            // If the string has only one character
            if (N == 1) {
                System.out.println(1);
                continue;
            }
            
            // Count transitions between 'A' and 'B'
            int transitions = 0;
            
            // Traverse through the string and count transitions
            for (int i = 1; i < N; i++) {
                if (S.charAt(i) != S.charAt(i - 1)) {
                    transitions++;
                }
            }
            
            // If there are no transitions (i.e., the string is made of same characters)
            if (transitions == 0) {
                System.out.println(N);
            } else {
                // Otherwise, the minimum operations needed is transitions + 1
                System.out.println(transitions + 1);
            }
            T--;
        }
        
        sc.close();
    }
}
