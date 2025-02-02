package codvita;
import java.util.*;

public class CodePress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of vertices
        int n = Integer.parseInt(sc.nextLine());
        int[][] vertices = new int[n][2];

        // Read vertices
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            vertices[i][0] = x;
            vertices[i][1] = y;

            // Update bounding box
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        // Brush size
        int m = Integer.parseInt(sc.nextLine());

        // Calculate wall dimensions
        int width = maxX - minX;
        int height = maxY - minY;

        // Calculate the number of presses required
        int pressesWidth = (int) Math.ceil((double) width / m);
        int pressesHeight = (int) Math.ceil((double) height / m);

        // Total presses
        int totalPresses = pressesWidth * pressesHeight;

        // Output the result
        System.out.println(totalPresses);
    }
}
