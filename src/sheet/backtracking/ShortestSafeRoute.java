package sheet.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestSafeRoute {
    static class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static boolean isValidCell(int[][] mat, int cr, int cc) {
        return cr >= 0 && cc >= 0 && cr < mat.length && cc < mat[0].length;
    }

    private static int helper(int[][] mat, int[] dxRow, int[] dyCol) {
        // mark all the cells near landmines as unsafe with -1
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    for(int k=0; k<4; k++) {
                        int r = i + dxRow[k];
                        int c = j + dyCol[k];
                        if(isValidCell(mat, r, c) && mat[r][c] == 1) {
                            mat[i + dxRow[k]][j + dyCol[k]] = -1;
                        }
                    }
                }
            }
        }

        // all the cells marks with -1, mark them 0 now
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }

        // replace all 1 with -1 in mat
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    mat[i][j] = -1;
                }
            }
        }

        Queue<Cell> q = new LinkedList<>();

        // add cells from first column which are safe
        for(int i=0; i<mat.length; i++) {
            if(mat[i][0] == -1) {
                q.add(new Cell(i, 0));
                mat[i][0] = 1;
            }
        }

        while(!q.isEmpty()) {
            Cell currCell = q.poll();

            // try to move in all four direction if possible
            for(int k=0; k<4; k++) {
                int nextRow = currCell.row + dxRow[k];
                int nextCol = currCell.col + dyCol[k];
                if(isValidCell(mat, nextRow, nextCol) && mat[nextRow][nextCol] == -1) {
                    q.add(new Cell(nextRow, nextCol));
                    mat[nextRow][nextCol] = mat[currCell.row][currCell.col] + 1;
                }
            }
        }

        int res = Integer.MAX_VALUE;
        // get the minimum value of distance from last column
        int lastCol = mat[0].length - 1;
        for (int[] row : mat) {
            if (row[lastCol] > 0) {
                res = Math.min(res, row[lastCol]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static int findShortestPath(int[][] mat) {
        int[] dxRow = {-1, 0, 1, 0};
        int[] dyCol = {0, 1, 0, -1};
        return helper(mat, dxRow, dyCol);
    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,1,1,1}, {1,1,1,1,1}, {1,1,1,1,1}, {1,1,1,0,1}, {1,1,1,1,0}};
        System.out.println(findShortestPath(mat));

        mat = new int[][] {{1,1,1,1,1}, {1,1,0,1,1}, {1,1,1,1,1}};
        System.out.println(findShortestPath(mat));

        mat = new int[][] {{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                            { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                            { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }};
        System.out.println(findShortestPath(mat));

        mat = new int[][] {{1,1,0,1,1,0}, {1,1,1,1,1,1}, {1,1,1,1,1,1}, {1,1,1,0,0,1}, {1,1,1,1,1,1}, {1,1,1,0,1,1},
                {1,0,1,1,1,0}, {1,0,1,1,1,1}, {1,1,1,1,1,1}};
        System.out.println(findShortestPath(mat));
    }
}
