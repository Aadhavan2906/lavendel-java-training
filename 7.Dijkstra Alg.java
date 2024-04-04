import java.util.ArrayList;
import java.util.List;

class Graph {
    List<List<Edge>> adjList;
    int numVertices;
    int[] dist;
    int[] prev;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
        this.dist = new int[numVertices];
        this.prev = new int[numVertices];
    }

    public void addEdge(int src, int dest, int weight) {
        adjList.get(src).add(new Edge(dest, weight));
    }

    public void dijkstra(int src) {
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[src] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            for (Edge edge : adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Edge(v, dist[v]));
                    prev[v] = u;
                }
            }
        }
    }

    public List<Integer> getShortestPath(int dest) {
        List<Integer> path = new ArrayList<>();
        while (dest != -1) {
            path.add(dest);
            dest = prev[dest];
        }
        Collections.reverse(path);
        return path;
    }
}