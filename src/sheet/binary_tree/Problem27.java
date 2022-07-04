package sheet.binary_tree;

import java.util.*;

public class Problem27 {
    private static Map<Integer, ArrayList<Integer>> adjList; //Adjacency List

    private static class Graph {
        Graph(int v) {
            adjList = new HashMap<>();
        }

        //for undirected graph
        void addEdge(int v,int w) {
            //add w as neighbour of v
            ArrayList<Integer> neighbourList = adjList.getOrDefault(v, new ArrayList<>());
            neighbourList.add(w);
            adjList.put(v, neighbourList);
            //add v as neighbour of w
            neighbourList = adjList.getOrDefault(w, new ArrayList<>());
            neighbourList.add(v);
            adjList.put(w, neighbourList);
        }
    }

    public static boolean validTree(int n, int edgeCount) {
        if(edgeCount < n-1) {
            return false;
        }
        HashSet<Integer> vis = new HashSet<>();
        vis.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        while(!q.isEmpty()) {
            int frontV = q.poll();
            ArrayList<Integer> neighbourList = adjList.getOrDefault(frontV, new ArrayList<>());
            for(int neigh: neighbourList) {
                if(!vis.contains(neigh)) {
                    q.add(neigh);
                    vis.add(neigh);
                    parent[neigh] = frontV;
                } else if(parent[frontV] != neigh) {
                    return false;
                }
            }
        }
        return (vis.size() == n);
    }

    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        System.out.println(validTree(5, 4));

        Graph g2 = new Graph(5);
        g2.addEdge(1, 0);
        g2.addEdge(0, 2);
        g2.addEdge(2, 1);
        g2.addEdge(0, 3);
        g2.addEdge(3, 4);
        System.out.println(validTree(5, 5));
    }
}
