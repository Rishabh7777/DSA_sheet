package random.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    private static boolean[] vis;
    private static int[] dist;
    private static PriorityQueue<Node> pq;
    private static List<List<Node>> adjList;

    // for priority queue
    static class comparator implements Comparator<Node> {
        @Override
        public int compare(Node node0, Node node1) {
            return node0.weight - node1.weight;
        }
    }

    static class Node {
        int val;
        int weight;

        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    static class Graph {
        int numV;

        Graph(int numV) {
            adjList = new ArrayList<>();
            this.numV = numV;
            vis = new boolean[numV];
            dist = new int[numV];
            pq = new PriorityQueue<>(new comparator());
        }
    }

    public static void dijkstra(int src, int numV) {
        // initially distance of all nodes is infinity
        for(int i=0; i<numV; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        // add every vertex to pq
        for(int i=0; i<numV; i++) {
            pq.add(new Node(i, dist[i]));
        }

        while(!pq.isEmpty()) {
            Node min = pq.remove();
            vis[min.val] = true;
            List<Node> neighbourList = adjList.get(min.val);

            // update dist of neighbours if needed
            for(Node neighbour: neighbourList) {
                if(!vis[neighbour.val] && (dist[min.val] + neighbour.weight < dist[neighbour.val])) {
                    pq.remove(neighbour);
                    dist[neighbour.val] = dist[min.val] + neighbour.weight;
                    pq.add(new Node(neighbour.val, dist[neighbour.val]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int numV = 9;
        new Graph(numV);

        // initialize lists for each node in adjList
        for(int i=0; i<numV; i++) {
            List<Node> item = new ArrayList<>();
            adjList.add(item);
        }

        adjList.get(0).add(new Node(1, 4));
        adjList.get(0).add(new Node(7, 8));
        adjList.get(1).add(new Node(0, 4));
        adjList.get(1).add(new Node(2, 8));
        adjList.get(1).add(new Node(7, 11));
        adjList.get(2).add(new Node(1, 8));
        adjList.get(2).add(new Node(3, 7));
        adjList.get(2).add(new Node(5, 4));
        adjList.get(2).add(new Node(8, 2));
        adjList.get(3).add(new Node(2, 7));
        adjList.get(3).add(new Node(4, 9));
        adjList.get(3).add(new Node(5, 14));
        adjList.get(4).add(new Node(3, 9));
        adjList.get(4).add(new Node(5, 10));
        adjList.get(5).add(new Node(2, 4));
        adjList.get(5).add(new Node(3, 14));
        adjList.get(5).add(new Node(4, 10));
        adjList.get(5).add(new Node(6, 2));
        adjList.get(6).add(new Node(5, 2));
        adjList.get(6).add(new Node(7, 1));
        adjList.get(6).add(new Node(8, 6));
        adjList.get(7).add(new Node(0, 8));
        adjList.get(7).add(new Node(1, 11));
        adjList.get(7).add(new Node(6, 1));
        adjList.get(7).add(new Node(8, 7));
        adjList.get(8).add(new Node(2, 2));
        adjList.get(8).add(new Node(6, 6));
        adjList.get(8).add(new Node(7, 7));

        int src = 7;
        dijkstra(src, numV);

        for(int i=0; i<numV; i++) {
            System.out.println("Distance of " + i + " from " + src + " = " + dist[i]);
        }
    }
}
