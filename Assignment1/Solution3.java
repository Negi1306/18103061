import java.util.*;
public class Solution3 {
    public Graph graph;
    public class Graph{
        private final int V, E;
        private final Edge[] edges;
        public Graph(int V, int E) {
            this.V = V;
            this.E = E;
            this.edges = new Edge[E];
        }
        private class Edge{
            int src, dest, weight;
            Edge(int src, int dest, int weight){
                this.src = src;
                this.dest = dest;
                this.weight = weight;
            }
        }
        private void addEdge(int[] src, int[] dest, int[] weight){
            for(int i=0; i<this.E; i++)
                this.edges[i] = new Edge(src[i], dest[i], weight[i]);
        }
    }
    public Solution3(int V, int E, int[] src, int[] dest, int[] weight) {
        this.graph = new Graph(V,E);
        this.graph.addEdge(src, dest, weight);
    }
    public String BellmanFord(int src, int dest) { 
            int[] dist = new int[this.graph.V]; 
            int[] edgeTo = new int[this.graph.V];

            for (int i = 0; i < this.graph.V; ++i) 
                dist[i] = Integer.MAX_VALUE; 
            dist[src] = 0;
            edgeTo[src] = -1;

            for (int i = 1; i < this.graph.V; ++i) { 
                for (int j = 0; j < this.graph.E; ++j) { 
                    int u = this.graph.edges[j].src; 
                    int v = this.graph.edges[j].dest; 
                    int weight = this.graph.edges[j].weight; 
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]){ 
                        dist[v] = dist[u] + weight; 
                        edgeTo[v] = u;
                    }
                } 
            } 

            for (int j = 0; j < this.graph.E; ++j) { 
                int u = this.graph.edges[j].src; 
                int v = this.graph.edges[j].dest; 
                int weight = this.graph.edges[j].weight; 
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
                    return "Negative cycles exist"; 
                } 
            }
            
            Stack<Integer> stack = new Stack<>();
            int u = dest;
            stack.push(u);
            while(edgeTo[u] != -1){
                stack.push(edgeTo[u]);
                u = edgeTo[u];
            }
            
            StringBuilder path = new StringBuilder();
            while(!stack.isEmpty()){
                path.append(stack.pop());
                if(!stack.isEmpty()) path.append(" -> ");
            }
            return path.toString();
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Find shortest path or negative cycles in graph");
        System.out.println("Enter the number of vertices and edges in the graph: ");
        int num_vertices = scan.nextInt();
        int num_edges = scan.nextInt();
        int[] src = new int[num_edges];
        int [] des = new int[num_edges];
        int[] weight = new int[num_edges];
        System.out.println("Enter source, destination and weight for each edge");
        for(int i=0; i<num_edges; i++){
            src[i] = scan.nextInt();
            des[i] = scan.nextInt();
            weight[i] = scan.nextInt();
         }
        Solution3 shortestPath = new Solution3(num_vertices, num_edges, src, des, weight);
        System.out.println("Enter source and destination: ");
        int s = scan.nextInt();
        int d = scan.nextInt();
        System.out.println(shortestPath.BellmanFord(s, d));   
    }
}