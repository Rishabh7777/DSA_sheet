package sheet.backtracking;

import java.util.ArrayList;

public class NQueen {
    // function to check if a queen can be placed in a particular row or not
    private static boolean canPlace(int n, int[][] board, int cr, int cc) {
        // check no queen should be placed in current column
        for(int i=0; i<cr; i++) {
            if(board[i][cc] == 1) {
                return false;
            }
        }

        // check no queen should be placed on left diagonal
        int row = cr, col = cc;
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        // check no queen should be placed on right diagonal
        row = cr;
        col = cc;
        while(row >= 0 && col < n) {
            if(board[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }

        // queen can be placed at board[cr][cc]
        return true;
    }

    public static void placeNQueens(int n, int[][] board, int cr, ArrayList<ArrayList<Integer>> res) {
        // base case, all queens are placed properly
        if(cr == n) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int row=0; row<n; row++) {
                for(int col=0; col<n; col++) {
                    if(board[row][col] == 1) {
                        list.add(col + 1);
                        break;
                    }
                }
            }
            res.add(list);
            return;
        }

        // check at which column, the queen can be placed in particular row
        for(int cc=0; cc<n; cc++) {
            if(canPlace(n, board, cr, cc)) {
                board[cr][cc] = 1; // mark queen position
                placeNQueens(n, board, cr+1, res); // recursive call to place queens in following rows
                board[cr][cc] = 0; // backtracking step
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        placeNQueens(n, board, 0, res);
        System.out.println(res);
    }
}
