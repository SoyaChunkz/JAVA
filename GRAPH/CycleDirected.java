package GRAPH;

import java.util.*;

public class CycleDirected {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // graph1 - true
    static void createGraph1(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    // graph2 - false
    static void createGraph2(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCyclicUtil(ArrayList<Edge> graph[], boolean[] visited, int curr, boolean[] recursionStack){
        visited[curr] = true;
        recursionStack[curr] = true;

        for( int i=0; i<graph[curr].size(); i++ ){
            Edge e = graph[curr].get(i);

            if( recursionStack[e.dest] )
                return true;
            else if( !(visited[e.dest])  && isCyclicUtil(graph, visited, e.dest, recursionStack) )
                return true;
        }

        recursionStack[curr] = false;
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean recursionStack[] = new boolean[graph.length];

        for( int i=0; i<graph.length; i++ ){
            if( !(visited[i]) ){
                if(isCyclicUtil(graph, visited, i, recursionStack))
                    return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        int V = 4;
        ArrayList<Edge> graph1[] = new ArrayList[V];
        ArrayList<Edge> graph2[] = new ArrayList[V];
        createGraph1(graph1);
        createGraph2(graph2);
        
        System.out.println(isCyclic(graph1));
        System.out.println(isCyclic(graph2));
    }

}
