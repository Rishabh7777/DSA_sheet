package random.graph;

import java.util.*;

public class GraphValidTree {
    private static Map<Integer, List<Integer>> adjList;

    private static void buildGraph(int[][] edges) {
        adjList = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> list = adjList.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            adjList.put(edge[0], list);

            List<Integer> list2 = adjList.getOrDefault(edge[1], new ArrayList<>());
            list2.add(edge[0]);
            adjList.put(edge[1], list2);
        }
    }

    private static boolean validTree(int n, int[][] edges) {
        //tree must have n-1 edges
        if(edges.length < (n-1)) {
            return false;
        }

        buildGraph(edges);

        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        while(!q.isEmpty()) {
            int frontV = q.poll();
            List<Integer> neighbourList = adjList.getOrDefault(frontV, new ArrayList<>());
            for(int neighbour: neighbourList) {
                if(!vis.contains(neighbour)) {
                    q.add(neighbour);
                    vis.add(neighbour);
                    parent[neighbour] = frontV;
                } else if(parent[frontV] != neighbour) {
                    return false;
                }
            }
        }

        //no cycle, but is tree or not like {{1,2}, {2,3}, {3,1}} and n=4
        return vis.size() == n;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,1}};
        System.out.println(validTree(4, edges));
    }
}
