package random.graph;

import java.util.*;

public class DetectCycleInDirected {
    private static boolean dfsHelper(int src, List<Integer> path, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        path.add(src);
        List<Integer> neighbourList = adj.get(src);
        for(int neighbour: neighbourList) {
            if(!vis[neighbour]) {
                if(dfsHelper(neighbour, path, vis, adj)) {
                    return true;
                }
            } else if(path.contains(neighbour)) {
                return true; //cycle found
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfsHelper(i, new ArrayList<>(), vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] findInDegree(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        for (List<Integer> neighbourList : adj) {
            for (int vertex : neighbourList) {
                inDegree[vertex]++;
            }
        }
        return inDegree;
    }

    public static boolean usingBFS(int V, ArrayList<ArrayList<Integer>> adj) {
        // topological sort is not possible if graph contains a cycle
        int[] inDegree = findInDegree(V, adj);
        int count = 0; // number of visited vertices
        Queue<Integer> q = new LinkedList<>();

        // fill q with vertex with inDegree 0
        // also include first nodes of all disconnected components of graph
        for(int i=0; i<V; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            int frontV = q.poll();
            List<Integer> neighbourList = adj.get(frontV);
            for(int neighbour: neighbourList) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    count++;
                    q.add(neighbour);
                }
            }
        }

        return (count != V);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(3)));
        adj.add(new ArrayList<>(List.of()));
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(2)));

        System.out.println(usingBFS(V, adj));
    }
}
