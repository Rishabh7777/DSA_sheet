package sheet.backtracking;

import java.util.Arrays;

public class KnightTour {
    public static boolean sol(int n, int[][] board, int cr, int cc, int steps, int[] x, int[] y) {
        // base cases
        // goes outside of board
        if(cr < 0 || cr >= n || cc < 0 || cc >= n) {
            return false;
        }
        // already visited cell
        if(board[cr][cc] != -1) {
            return false;
        }

        // assign current step count to current cell
        board[cr][cc] = steps;

        // filled the board completely with steps
        if(steps + 1 == n * n) {
            return true;
        }

        // the knight has total of 8 direction to move
        for(int i=0; i<x.length; i++) {
            if(sol(n, board, cr + x[i], cc + y[i], steps + 1, x, y)) {
                return true;
            }
        }

        // backtracking step
        board[cr][cc] = -1;
        return false;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] board = new int[n][n];
        for(int[] i: board) {
            Arrays.fill(i, -1);
        }
        int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] y = {1, 2, 2, 1, -1, -2, -2, -1};
        if(sol(n, board, 0, 0, 0, x, y)) {
            for(int[] i: board) {
                System.out.println(Arrays.toString(i));
            }
        } else {
            System.out.println("Solution not possible");
        }
    }
}
