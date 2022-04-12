package random.graph;

import java.util.*;

public class DisjointSetUnion {

    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{" + this.u + ", " + this.v + ", " + this.weight + "}";
        }
    }

    // to hold parent and rank
    static class Parent {
        int parent;
        int rank; //number of nodes in the tree

        Parent(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "(" + this.parent + ", " + this.rank + ")";
        }
    }

    private static List<Edge> edgeList;

    // optimized using path compression
    private static int findLeader(int u, Parent[] parent) {
        if(parent[u].parent == -1) {
            return u;
        }

        // make root as the parent of nodes(visited during call) deeper in the tree
        // to make sure better speed the next time
        return parent[u].parent = findLeader(parent[u].parent, parent);
    }

    public static void union(Parent[] parent) {
        for(Edge edge: edgeList) {
            int u = edge.u;
            int v = edge.v;

            int leaderU = findLeader(u, parent);
            int leaderV = findLeader(v, parent);

            // optimized using union by rank
            // subset with less depth will be child of leader of subset having greater depth
            if(leaderU != leaderV) {
                if (parent[leaderU].rank < parent[leaderV].rank) {
                    parent[leaderU].parent = leaderV;
                    parent[leaderV].rank += parent[leaderU].rank;
                } else if (parent[leaderU].rank > parent[leaderV].rank) {
                    parent[leaderV].parent = leaderU;
                    parent[leaderU].rank += parent[leaderV].rank;
                } else {
                    parent[leaderU].parent = leaderV;
                    parent[leaderV].rank += parent[leaderU].rank;
                }
            }
        }
    }

    public static boolean hasCycle(Parent[] parent) {
        for(Edge edge: edgeList) {
            int u = edge.u;
            int v = edge.v;

            int leaderU = findLeader(u, parent);
            int leaderV = findLeader(v, parent);

            if(leaderU == leaderV) {
                return true;
            } else {
                union(parent);
            }
        }
        return false;
    }

    public static int kruskalAlgorithm(Parent[] parent) {
        System.out.println("Edges involved:");
        // through local minima reach the minima
        edgeList.sort(Comparator.comparingInt(o -> o.weight));
        int cost = 0;
        for(Edge edge: edgeList) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
            int godFatherU = findLeader(u, parent);
            int godFatherV = findLeader(v, parent);
            if(godFatherU != godFatherV) {
                cost += weight;
                System.out.println(u + " -> " + v);
                parent[godFatherU].parent = godFatherV;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        edgeList = new ArrayList<>();
        int v = 9;
        Parent[] parent = new Parent[v];
        for(int i=0; i<v; i++) {
            parent[i] = new Parent(-1, 1);
        }

        edgeList.add(new Edge(0, 1, 4));
        edgeList.add(new Edge(2, 3, 7));
        edgeList.add(new Edge(2, 8, 2));
        edgeList.add(new Edge(0, 7, 8));
        edgeList.add(new Edge(1, 2, 8));
        edgeList.add(new Edge(1, 7, 11));
        edgeList.add(new Edge(2, 5, 4));
        edgeList.add(new Edge(3, 4, 9));
        edgeList.add(new Edge(3, 5, 14));
        edgeList.add(new Edge(4, 5, 10));
        edgeList.add(new Edge(5, 6, 2));
        edgeList.add(new Edge(6, 7, 1));
        edgeList.add(new Edge(6, 8, 6));
        edgeList.add(new Edge(7, 8, 7));

        System.out.println("Min cost = " + kruskalAlgorithm(parent));
    }
}