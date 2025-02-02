import java.util.Scanner;

public class AssignmentScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // Number of test cases

        while (T > 0) {
            int N = sc.nextInt();  // Number of completed assignments
            int[] A = new int[N];
            int sum_A = 0;

            // Reading the scores for the first N assignments and calculating their sum
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
                sum_A += A[i];
            }

            // The total score that Chef needs to achieve 50% of total possible marks
            int requiredTotal = 50 * (N + 1);  // 50% of (N+1) assignments

            // Minimum score needed on the last assignment to pass
            int requiredLastAssignmentScore = requiredTotal - sum_A;

            if (requiredLastAssignmentScore <= 0) {
                // If Chef needs no score on the last assignment to pass
                System.out.println(0);
            } else if (requiredLastAssignmentScore > 100) {
                // If the required score exceeds 100, it's impossible to pass
                System.out.println(-1);
            } else {
                // Otherwise, output the minimum score needed on the last assignment
                System.out.println(requiredLastAssignmentScore);
            }
            T--;
        }

        sc.close();
    }
}
