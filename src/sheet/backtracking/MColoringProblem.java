package sheet.backtracking;

public class MColoringProblem {
    private static boolean helper(boolean[][] graph, int m, int n, int[] colors, int currNode) {
        // base case
        if(currNode == n) {
            return true;
        }

        // pick a color for current node
        for(int i=1; i<=m; i++) {
            // the picked color i.e. i should not be present at any neighbour
            int col = 0;
            for(; col<n; col++) {
                // if edge is found between col and currNode and is colored with i
                if(graph[currNode][col] && colors[col] == i) {
                    break;
                }
            }

            if(col == n) {
                colors[currNode] = i;
                // color next node with recursive call
                boolean res = helper(graph, m, n, colors, currNode + 1);
                // if found a solution i.e. res == true
                if(res) {
                    return true;
                }
                // backtracking steps
                colors[currNode] = 0;
            }
        }

        return false;
    }

    public static boolean graphColoring(boolean[][] graph, int m, int n) {
        return helper(graph, m, n, new int[n], 0);
    }

    public static void main(String[] args) {
        int n = 3, m = 2;
        boolean[][] graph = {{false, true, true}, {true, false, true}, {true, true, false}};
        System.out.println(graphColoring(graph, m, n));
    }
}
