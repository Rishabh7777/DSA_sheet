package sheet.backtracking;

import java.util.ArrayList;

public class LongestRoute {
    private static int helper(int[][] mat, int cr, int cc, int xd, int yd,  ArrayList<String> vis, int pathLen) {
        // base case
        if(cr < 0 || cc < 0 || cr >= mat.length || cc >= mat[0].length || mat[cr][cc] == 0) {
            return -1;
        }
        if(vis.contains((cr+1) + "" + (cc+1))) {
            return -1;
        }
        if(cr == xd && cc == yd) {
            return pathLen;
        }

        // add current cell to visited list
        String s = (cr + 1) + "" + (cc + 1);
        vis.add(s);

        // make recursive calls to adjacent cells
        int right = helper(mat, cr, cc+1, xd, yd, vis, pathLen+1);
        int down = helper(mat, cr+1, cc, xd, yd, vis, pathLen+1);
        int left = helper(mat, cr, cc-1, xd, yd, vis, pathLen+1);
        int top = helper(mat, cr-1, cc, xd, yd, vis, pathLen+1);

        // backtracking step
        vis.remove(vis.size() - 1);

        return Math.max(right, Math.max(down, Math.max(left, top)));
    }

    public static int longestPath(int[][] mat, int n, int m, int xs, int ys, int xd, int yd) {
        return helper(mat, xs, ys, xd, yd, new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        int[][] mat = {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};

        int xs = 0, ys = 0, xd = 1, yd = 7;

        System.out.println(longestPath(mat, mat.length, mat[0].length, xs, ys, xd, yd));

        mat = new int[][] {{1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0}};

        xs = 0;
        ys = 3;
        xd = 2;
        yd = 2;

        System.out.println(longestPath(mat, mat.length, mat[0].length, xs, ys, xd, yd));
    }
}
