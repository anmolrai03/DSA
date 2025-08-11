package assessment;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class SafeViewPointsSolver {
   /**
    * Computes the number of leaf nodes reachable from the root
    * without crossing more than M consecutive hazardous nodes.
    *
    * @param N     number of nodes in the tree
    * @param M     maximum allowed consecutive hazardous nodes
    * @param k     number of edges (should be N-1 for a tree)
    * @param Arr1  list of size N, where Arr1.get(i) is 0 (safe) or 1 (hazardous) for node i (0-indexed)
    * @param Arr2  list of k edges, each edge is a list [u, v] representing an undirected edge between nodes u and v (1-indexed)
    * @return      count of leaf nodes safely reachable from root (node 1, index 0)
    */
   public static int safeViewPoints(int N, int M, int k,
                                    List<Integer> Arr1,
                                    List<List<Integer>> Arr2) {
      // Build adjacency list for the tree
      List<List<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < N; i++) {
         adj.add(new ArrayList<>());
      }
      // Populate adjacency list (convert to 0-based indexing if edges are 1-based)
      for (List<Integer> edge : Arr2) {
         int u = edge.get(0) - 1;  // convert to 0-based
         int v = edge.get(1) - 1;
         adj.get(u).add(v);
         adj.get(v).add(u);
      }

      boolean[] visited = new boolean[N];
      // Use a stack for DFS to avoid recursion limit for large N
      Deque<int[]> stack = new ArrayDeque<>();
      // Start from root (node 0) with initial consecutive hazardous count
      stack.push(new int[]{0, Arr1.get(0) == 1 ? 1 : 0});
      visited[0] = true;
      int safeLeaves = 0;

      while (!stack.isEmpty()) {
         int[] current = stack.pop();
         int node = current[0];
         int consecHaz = current[1];

         // If consecutive hazardous count exceeds M, skip this branch
         if (consecHaz > M) {
            continue;
         }

         // Check if it is a leaf:
         // In a tree, a leaf has exactly one neighbor (the parent), except the root if N==1.
         boolean isLeaf = (node != 0 && adj.get(node).size() == 1)
             || (node == 0 && adj.get(node).isEmpty());
         if (isLeaf) {
            safeLeaves++;
         }

         // Traverse neighbors (children)
         for (int next : adj.get(node)) {
            if (!visited[next]) {
               visited[next] = true;
               // Compute next consecutive hazardous count
               int nextHaz = Arr1.get(next) == 1 ? consecHaz + 1 : 0;
               stack.push(new int[]{next, nextHaz});
            }
         }
      }
      return safeLeaves;
   }

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int N = Integer.parseInt(scan.nextLine().trim());
      int M = Integer.parseInt(scan.nextLine().trim());
      int k = Integer.parseInt(scan.nextLine().trim());

      List<Integer> Arr1 = new ArrayList<>(N);
      for(int j = 0; j < N; j++) {
         Arr1.add(Integer.parseInt(scan.nextLine().trim()));
      }

      List<List<Integer>> Arr2 = new ArrayList<>(k);
      for(int i = 0; i < k; i++) {
         Arr2.add(
             Arrays.asList(scan.nextLine().trim().split(" "))
                 .stream().map(s -> Integer.parseInt(s))
                 .collect(toList())
         );
      }

      int result = safeViewPoints(N, M, k, Arr1, Arr2);
      System.out.println(result);
   }

}
