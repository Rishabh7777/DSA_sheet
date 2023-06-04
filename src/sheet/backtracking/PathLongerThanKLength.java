package sheet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PathLongerThanKLength {
    private static boolean helper(int[][] graph, int K, int pathLen, int vertex, ArrayList<Integer> vis) {
        if(pathLen >= K) {
            return true;
        }

        // traverse through the vertex row in graph
        // find a non-visited vertex from current vertex and move to it
        for(int i=0; i<graph.length; i++) {
            if(graph[vertex][i] != -1 && !vis.contains(i)) {
                vis.add(i);
                boolean res = helper(graph, K, pathLen+graph[vertex][i], i, vis);
                if(res) {
                    return res;
                }
                vis.remove(vis.size() - 1);
            }
        }

        return false;
    }

    public static boolean pathMoreThanK(int V , int E , int K , int[] A) {
        int[][] graph = new int[V][V];

        //add V lists in graph
        for(int[] i: graph) {
            Arrays.fill(i, -1);
        }

        //traverse the A and make the graph
        for(int i=0; i<A.length-2; i=i+3) {
            graph[A[i]][A[i+1]] = Math.max(A[i+2], graph[A[i]][A[i+1]]);
            graph[A[i+1]][A[i]] = Math.max(A[i+2], graph[A[i+1]][A[i]]);
        }

        ArrayList<Integer> vis = new ArrayList<>();
        vis.add(0);
        return helper(graph, K, 0, 0, vis);
    }

    public static void main(String[] args) {
        int V = 5, E = 6, K = 96;
        int[] A = {1, 1, 20, 4, 0, 31, 2, 3, 64, 2, 4, 44, 4, 4, 88, 2, 4, 0};

        System.out.println(pathMoreThanK(V, E, K, A));
    }
}
