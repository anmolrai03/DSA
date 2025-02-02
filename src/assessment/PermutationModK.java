import java.util.Scanner;

public class PermutationModK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        StringBuilder output = new StringBuilder();

        while (T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // If N is not divisible by K, it's impossible to form a valid permutation
            if (N % K != 0) {
                output.append("-1\n");
                continue;
            }

            // Construct the permutation
            int[] P = new int[N];
            for (int i = 0; i < N; i++) {
                P[i] = (i + K) % N + 1; // Cyclically shift by K positions
            }

            // Append the result
            for (int i = 0; i < N; i++) {
                output.append(P[i]).append(" ");
            }
            output.append("\n");
        }

        // Print all results
        System.out.print(output);
    }
}
