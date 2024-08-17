package GRAPH;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju {
    
    static class Edge {
        
        int src;
        int dest;

        public Edge(int s, int d){

            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> stack){

        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if( !visited[e.dest] )
                topSort(graph, e.dest, visited, stack);
        }
        stack.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        
        visited[curr] = true;
        System.out.print(curr+" ");

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if( !visited[e.dest] )
                dfs(graph, e.dest, visited);
        }
    }

    public static void kosaraju(ArrayList<Edge> graph[]){

        //step1 - topological sorting O(V+E) 
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[graph.length];
        for( int i=0; i<graph.length; i++ ){
            if( !visited[i] ){
                topSort(graph, i, visited, stack);
            }
        }

        //step2 - transposing the graph O(V+E) 
        ArrayList<Edge> transpose[] = new ArrayList[graph.length];
        for( int i=0; i<graph.length; i++ ){
            visited[i] = false;
            transpose[i] = new ArrayList<Edge>();
        }
        for( int i=0; i<graph.length; i++ ){
            for( int j=0; j<graph[i].size(); j++ ){
                Edge e = graph[i].get(j);
                //e.src -> e.dest   ---->  e.dest -> e.src
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        //step3 - simple dfs on transposed graph O(V+E) 
        while( !stack.isEmpty() ){
            int curr = stack.pop();
            if( !visited[curr] ){
                System.out.print("SCC : ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        
        int V = 5;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        kosaraju(graph);
    }
}
