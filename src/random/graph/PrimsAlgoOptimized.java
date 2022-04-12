package random.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

public class PrimsAlgoOptimized {
    // will be used to form a list of neighbour vertices to a vertex
    static class Node1 {
        int dest; // store destination vertex
        int weight; // store weight from curr to dest vertex

        Node1(int a, int b) {
            dest = a;
            weight = b;
        }
    }

    static class Graph {
        int V; // total number of vertices in graph

        // an array of neighbouring vertices, index pointing to curr vertex
        LinkedList<Node1>[] adj; // adj[idx] -> node1 -> node2

        Graph(int e) {
            V = e;
            adj = new LinkedList[V];
            for (int o = 0; o < V; o++) {
                adj[o] = new LinkedList<>();
            }
        }
    }

    // to store vertices in priority queue with key(or weight)
    static class Node {
        int vertex;
        int key;
    }

    // for priority queue
    static class comparator implements Comparator<Node> {
        @Override
        public int compare(Node node0, Node node1) {
            return node0.key - node1.key;
        }
    }

    private static void addEdge(Graph graph, int v1, int v2, int weight) {
        Node1 node0 = new Node1(v2, weight);
        Node1 node = new Node1(v1, weight);
        graph.adj[v1].addLast(node0);
        graph.adj[v2].addLast(node);
    }

    private static int prims_mst(Graph graph) {
        boolean[] vis = new boolean[graph.V]; // initially all vertices are not visited
        Node[] pqNodes = new Node[graph.V];

        int[] parent = new int[graph.V];
        int cost = 0;

        // initialize each cell of node[]
        for (int o = 0; o < graph.V; o++) {
            pqNodes[o] = new Node();
        }

        // initialize the pqNodes[]
        // all key values to infinity, vertex values to respective vertices
        // and parent of each vertex to -1 initially
        for (int o = 0; o < graph.V; o++) {
            pqNodes[o].key = Integer.MAX_VALUE;
            pqNodes[o].vertex = o;
            parent[o] = -1;
        }

        // Include the source vertex in vis
        vis[0] = true;

        // Set key value to 0, so that it is extracted first out of PriorityQueue
        pqNodes[0].key = 0;

        TreeSet<Node> queue = new TreeSet<>(new comparator());

        queue.addAll(Arrays.asList(pqNodes)); // add complete pqNodes[] to queue

        while (!queue.isEmpty()) {
            Node node0 = queue.pollFirst(); // will get node with minimum key value

            vis[node0.vertex] = true;
            cost += node0.key;

            // loop for all neighbouring vertices of node0
            for (Node1 iterator : graph.adj[node0.vertex]) {
                // perform action if vertex is not already visited
                if(!vis[iterator.dest]) {
                    // If the key value of the adjacent vertex is
                    // more than the extracted key
                    // update the key value of adjacent vertex
                    // to update first remove and add the updated vertex
                    if (pqNodes[iterator.dest].key > iterator.weight) {
                        queue.remove(pqNodes[iterator.dest]);
                        pqNodes[iterator.dest].key = iterator.weight;
                        queue.add(pqNodes[iterator.dest]);
                        parent[iterator.dest] = node0.vertex;
                    }
                }
            }
        }

        // Prints the vertex pair of mst
        for (int o = 1; o < graph.V; o++) {
            System.out.println(parent[o] + " " + "-" + " " + o);
        }

        return cost;
    }

    public static void main(String[] args) {
        int V = 9;
        Graph graph = new Graph(V);

        addEdge(graph, 0, 7, 8);
        addEdge(graph, 1, 2, 8);
        addEdge(graph, 0, 1, 4);
        addEdge(graph, 1, 7, 11);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 2, 8, 2);
        addEdge(graph, 2, 5, 4);
        addEdge(graph, 3, 4, 9);
        addEdge(graph, 3, 5, 14);
        addEdge(graph, 4, 5, 10);
        addEdge(graph, 5, 6, 2);
        addEdge(graph, 6, 7, 1);
        addEdge(graph, 6, 8, 6);
        addEdge(graph, 7, 8, 7);

        System.out.println("Total cost = " + prims_mst(graph));
    }
}
