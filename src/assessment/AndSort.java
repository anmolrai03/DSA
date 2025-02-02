import java.io.*;
import java.util.*;

public class AndSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // Number of test cases

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // Size of array A
            int[] A = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            // Compute bitmask constraints
            int X = (1 << 30) - 1; // Start with all bits set (up to 30 bits)
            for (int i = 0; i < N - 1; i++) {
                if (A[i] > A[i + 1]) {
                    X &= ~(A[i] & ~A[i + 1]); // Clear bits that violate the condition
                }
            }

            // Validate and count good X values
            int count = 0;
            for (int i = 0; i <= N; i++) {
                if ((i & X) == i) {
                    boolean isSorted = true;
                    for (int j = 0; j < N - 1; j++) {
                        if ((A[j] & i) > (A[j + 1] & i)) {
                            isSorted = false;
                            break;
                        }
                    }
                    if (isSorted) count++;
                }
            }

            output.append(count).append("\n");
        }

        System.out.print(output);
    }
}
