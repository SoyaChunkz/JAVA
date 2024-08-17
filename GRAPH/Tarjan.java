package GRAPH;

import java.util.ArrayList;

public class Tarjan {
    
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    }


    public static void tarjan(ArrayList<Edge> graph[], int curr, int time,boolean visited[], int dt[], int low[], int parent){

        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for( int i=0; i<graph[curr].size(); i++ ){

            Edge e = graph[curr].get(i);
            if( e.dest == parent ) //if neighbour is parent move to next neighbour
                continue;
            else if( !visited[e.dest] ){
                tarjan(graph, e.dest, time, visited, dt, low, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if( dt[curr] < low[e.dest] ) //bridge condition
                    System.out.println("Bridge at : " + curr + "----" + e.dest);
            }
            else if( visited[e.dest] )
                low[curr] = Math.min(low[curr], dt[e.dest]);
        }
    }

    public static void getBridge(ArrayList<Edge> graph[]){

        int dt[] = new int[graph.length];  //discovery time
        int low[] = new int[graph.length];  //lowest discovery time
        boolean visited[] = new boolean[graph.length];
        int time = 0;
        
        for (int i = 0; i < graph.length; i++) {
            if( !visited[i] )
                tarjan(graph, i, time, visited, dt, low, -1);
        }

    }
    public static void main(String[] args) {
        
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getBridge(graph);
    }
}
