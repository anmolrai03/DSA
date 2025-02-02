import java.io.*;
import java.util.*;

public class ReconstructArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // Number of test cases
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // Size of array A
            int[] B = new int[N - 1]; // Array B
            
            String[] bValues = br.readLine().split(" ");
            for (int i = 0; i < N - 1; i++) {
                B[i] = Integer.parseInt(bValues[i]);
            }
            
            Arrays.sort(B); // Sort B to simplify reconstruction
            int[] A = new int[N];

            if (N == 3) {
                // Special case when N = 3
                A[0] = B[0] / 2;
                A[1] = B[0] - A[0];
                A[2] = B[1] - A[1];
            } else {
                // General case for N > 3
                A[0] = (B[0] - B[1] + B[2]) / 2;
                A[1] = B[0] - A[0];
                for (int i = 2; i < N; i++) {
                    A[i] = B[i - 1] - A[i - 1];
                }
            }
            
            // Append result for the current test case
            for (int i = 0; i < N; i++) {
                output.append(A[i]).append(i == N - 1 ? "\n" : " ");
            }
        }
        
        // Print all results
        System.out.print(output);
    }
}
