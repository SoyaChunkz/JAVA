package GRAPH;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {

    static class Edge {
        
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){

            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        
        int node;
        int cost;

        public Pair(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void prims(ArrayList<Edge> graph[]){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];
        int cost = 0;
        pq.add(new Pair(0, 0));

        while( !pq.isEmpty() ){
            Pair curr = pq.remove();
            if( !visited[curr.node] ){
                visited[curr.node] = true;
                cost += curr.cost;
                for( int i=0; i<graph[curr.node].size(); i++ ){
                    Edge e = graph[curr.node].get(i);
                    if( !visited[e.dest] )
                        pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("The total MST cost is : " + cost);
    }

    public static void prims(ArrayList<Edge> graph[], ArrayList<Edge> ans){

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[graph.length];
        pq.add(new Pair(0, 0));
    
        while( !pq.isEmpty() ){
            Pair curr = pq.remove();
            if( !visited[curr.node] ){
                visited[curr.node] = true;
                ans.add(new Edge(0, curr.node, curr.cost));
                for( int i=0; i<graph[curr.node].size(); i++ ){
                    Edge e = graph[curr.node].get(i);
                    if( !visited[e.dest] )
                        pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
    }

    public static void main(String[] args) {
        
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        ArrayList<Edge> ans = new ArrayList<>();
        prims(graph, ans);
        for( Edge e : ans ){
            System.out.println("Edge: " + e.src + " -> Edge: " + e.dest + " cost: " + e.wt);
        }

        prims(graph);
    }
}