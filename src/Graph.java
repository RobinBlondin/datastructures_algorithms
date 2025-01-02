import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<String, List<String>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void printGraph() {
        for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            String result = String.format("{ %s = %s }", key, value);
            System.out.println(result);
        }
    }

    public boolean addVertex(String vertex) {
        if(adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertexA, String vertexB) {
        if(adjList.get(vertexA) == null || adjList.get(vertexB) == null) {
            return false;
        }

        adjList.get(vertexA).add(vertexB);
        adjList.get(vertexB).add(vertexA);
        return true;
    }

    public boolean removeEdge(String vertexA, String vertexB) {
        if(adjList.get(vertexA) == null || adjList.get(vertexB) == null) {
            return false;
        }

        adjList.get(vertexA).remove(vertexB);
        adjList.get(vertexB).remove(vertexA);
        return true;
    }

}
