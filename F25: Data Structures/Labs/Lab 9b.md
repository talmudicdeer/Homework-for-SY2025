Alexis Baker


Data Structures


Lab 9b


12/10/2025


Here is a block of code that meets all of the tasks at once, with comments.


```java
import java.util.*;

// Graph class using adjacency list representation
class Graph {
    private Map<Integer, List<Integer>> adjList;

    // Constructor to initialize the graph
    public Graph() {
        adjList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices (undirected graph by default)
    public void addEdge(int vertex1, int vertex2) {
        adjList.putIfAbsent(vertex1, new ArrayList<>());
        adjList.putIfAbsent(vertex2, new ArrayList<>());
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);  // for undirected graph
    }

    // Display the graph
    public void display() {
        for (int vertex : adjList.keySet()) {
            System.out.print("Vertex " + vertex + ": ");
            for (int neighbor : adjList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Breadth First Search (BFS)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS traversal starting from vertex " + start + ": ");
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : adjList.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth First Search (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS traversal starting from vertex " + start + ": ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        System.out.print(vertex + " ");
        visited.add(vertex);
        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Method to generate a random graph
    public static Graph generateRandomGraph(int numVertices, int numEdges) {
        Graph graph = new Graph();
        Random random = new Random();

        // Add vertices
        for (int i = 1; i <= numVertices; i++) {
            graph.addVertex(i);
        }

        // Add random edges
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = random.nextInt(numVertices) + 1;
            int vertex2 = random.nextInt(numVertices) + 1;

            // Prevent adding self-loop (optional, depends on requirements)
            while (vertex1 == vertex2) {
                vertex2 = random.nextInt(numVertices) + 1;
            }

            graph.addEdge(vertex1, vertex2);
        }

        return graph;
    }

    // Method to compare BFS and DFS
    public static void compareBFSDFS(Graph graph, int start) {
        long startTime, endTime;

        // Measure BFS time
        startTime = System.nanoTime();
        graph.bfs(start);
        endTime = System.nanoTime();
        System.out.println("BFS time: " + (endTime - startTime) + " ns");

        // Measure DFS time
        startTime = System.nanoTime();
        graph.dfs(start);
        endTime = System.nanoTime();
        System.out.println("DFS time: " + (endTime - startTime) + " ns");
    }

    public static void main(String[] args) {
        // Generate a random graph with 10 vertices and 15 edges
        Graph graph = Graph.generateRandomGraph(10, 15);
        graph.display(); // Display the graph

        // Compare BFS and DFS performance
        int startVertex = 1;
        Graph.compareBFSDFS(graph, startVertex);
    }
}
```
