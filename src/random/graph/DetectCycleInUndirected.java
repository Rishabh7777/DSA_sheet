package random.graph;

import java.util.*;

public class DetectCycleInUndirected {
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        int[] parent = new int[V]; //of visited vertices
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                q.add(i);
                vis[i] = true;
                //at initial vertex itself is its parent
                for(int j=0; j<V; j++) {
                    parent[j] = j;
                }

                while(!q.isEmpty()) {
                    int frontV = q.poll();
                    List<Integer> neighbourList = adj.get(frontV);

                    for(int neighbour: neighbourList) {
                        if(!vis[neighbour]) {
                            q.add(neighbour);
                            vis[neighbour] = true;
                            parent[neighbour] = frontV;
                        } else if(parent[frontV] != neighbour) { //neighbour is visited but not parent of frontV
                            return true;
                        }
                    }
                }
            }
        }

        return false; //no cycle found
    }

    private static boolean dfsHelper(int src, boolean[] vis, int parent, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        List<Integer> neighbourList = adj.get(src);
        for(int neighbour: neighbourList) {
            if(!vis[neighbour]) {
                if(dfsHelper(neighbour, vis, src, adj)) {
                    return true;
                }
            } else if(neighbour != parent) {
                return true; //cycle found
            }
        }
        return false;
    }

    private static boolean usingDFS(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                if(dfsHelper(i, vis, i, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(0, 2)));
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(5)));
        adj.add(new ArrayList<>(List.of(5)));
        adj.add(new ArrayList<>(List.of(3, 4)));

        System.out.println(usingDFS(V, adj));
    }
}
