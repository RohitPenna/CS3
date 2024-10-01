import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
    private int x;
    private int y;
    private int ID;
    private List<Integer> edges;
    private boolean visited;
    private double distance;

    public Vertex(int x, int y, int ID) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.distance = Double.POSITIVE_INFINITY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getID() {
        return ID;
    }

    public List<Integer> getEdges() {
        return edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double distanceTo(Vertex other) {
        int dx = other.x - x;
        int dy = other.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
    }

    @Override
    public String toString() {
        return String.valueOf(ID);
    }
}

class Graph {
    //Scanner input = new Scanner(new File("input6.txt"));
    
    int V;
    int E;
    Vertex[] vertices;

    public Graph() 
    {
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new File("input6.txt"));
        }
        catch (Exception ignored) {}
        
        V = scanner.nextInt();
        E = scanner.nextInt();
        vertices = new Vertex[V];

        for (int i = 0; i < V; i++) {
            int ID = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            vertices[ID] = new Vertex(x, y, ID);
        }

        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            vertices[from].getEdges().add(to);
            vertices[to].getEdges().add(from);
        }
    }

    public double distance(int from, int to) {
        return vertices[from].distanceTo(vertices[to]);
    }

    public Vertex[] getVertices() {
        return vertices;
    }
}

class Dijkstra {
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public double distance(int source, int destination) {
        dijkstra(source, destination);
        return graph.getVertices()[destination].getDistance();
    }

    private void dijkstra(int source, int destination) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        Vertex sourceVertex = graph.getVertices()[source];
        sourceVertex.setDistance(0);
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            if (currentVertex.isVisited()) {
                continue;
            }
            currentVertex.setVisited(true);

            for (int neighborID : currentVertex.getEdges()) {
                Vertex neighbor = graph.getVertices()[neighborID];
                if (!neighbor.isVisited()) {
                    double distance = currentVertex.getDistance() + graph.distance(currentVertex.getID(), neighbor.getID());
                    if (distance < neighbor.getDistance()) {
                        neighbor.setDistance(distance);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
}

public class Main 
{
    public static void main(String[] args)
    {
        Dijkstra test = new Dijkstra(new Graph());
    }
}