package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
   static class Edge{
      int src;
      int dest;
//      int weight;

//      public Edge(int src, int dest, int weight) {
//         this.src = src;
//         this.dest = dest;
////         this.weight = weight;
//      }
      public Edge(int src, int dest) {
         this.src = src;
         this.dest = dest;
//         this.weight = weight;
      }
   }

   public static void createGraph(ArrayList<Edge> graph[]){

      for(int i =0; i < graph.length; i++){
         graph[i] = new ArrayList<Edge>();
      }

      graph[0].add(new Edge(0, 1));
      graph[0].add(new Edge(0, 2));

      graph[1].add(new Edge(1, 0));
      graph[1].add(new Edge(1, 3));

      graph[2].add(new Edge(2, 0));
      graph[2].add(new Edge(2, 4));

      graph[3].add(new Edge(3, 1));
      graph[3].add(new Edge(3, 4));
      graph[3].add(new Edge(3, 5));

      graph[4].add(new Edge(4, 2));
      graph[4].add(new Edge(4, 3));
      graph[4].add(new Edge(4, 5));

      graph[5].add(new Edge(5, 3));
      graph[5].add(new Edge(5, 4));
      graph[5].add(new Edge(5, 6));

      graph[6].add(new Edge(6, 5));
   }

   public static void bfs(ArrayList<Edge> graph[], int v){
      Queue<Integer> q = new LinkedList<>();
      boolean visited[] = new boolean[v];

      q.add(0);
      while(!q.isEmpty()){
         int curr = q.remove();

         if(!visited[curr]){

            System.out.print(curr+" ");
            visited[curr] = true;

            for(int i =0; i< graph[curr].size(); i++){
               Edge e = graph[curr].get(i);
               q.add(e.dest);
            }
         }
      }
   }

   //dfs O(V+E)
   public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]){

      //process
      System.out.print(curr+" ");

      //vis[curr] = true.
      vis[curr] = true;

      //next neighbors
      for(int i =0; i< graph[curr].size(); i++){
         Edge e = graph[curr].get(i);
         if(!vis[e.dest]){
            dfs(graph , e.dest , vis);
         }

      }
   }


   //printing all paths => O(V^V)
   public static void dfsM(ArrayList<Edge> graph[] , boolean vis[] , int curr ,
                           StringBuilder path , int tar){
      if(curr == tar){
         System.out.println(path);
         return;
      }

      for(int i =0; i<graph[curr].size(); i++){
         Edge e = graph[curr].get(i);

         if(vis[curr]  == false){
            vis[curr] = true;

            path.append(e.dest);
            
            dfsM(graph , vis , e.dest , path , tar);

            path.deleteCharAt(path.length() -1);
            vis[curr] =  false;
         }
      }
   }

   //main class
   public static void main(String[] args) {
      int v = 7; //vertex count.

      ArrayList<Edge> graph[] = new ArrayList[v];

      createGraph(graph);
      //print 2's neighbors.
//      for(int i = 0; i < graph[2].size(); i++){
//         Edge e = graph[2].get(i);
//         System.out.println(e.dest+" ");
//      }
//      System.out.println();

      bfs(graph, v);
      System.out.println();



      boolean[] vis = new boolean[v];


      //works in disjoints as well
//      for(int i =0; i < v; i++){
//         if(!vis[i]){
//            dfs(graph , 0, vis);
//         }
//      }

//      String sb = "0";
      StringBuilder sb = new StringBuilder();
      sb.append("0");
      dfsM(graph , vis , 0 , sb , 5);

//      dfs(graph , 0, vis);
   }
}
