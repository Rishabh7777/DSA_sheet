package sheet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class SolveSudoku {
    private static boolean isColumnUnsafe(int[][] grid, int row, int col, int num) {
        // check if num is present somewhere in current column
        for(int i=0; i<9; i++) {
            if(row == i) {
                continue;
            }
            if(grid[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMinGridUnsafe(int[][] grid, int row, int col, int num) {
        int rowGroup = row / 3;
        int colGroup = col / 3;
        int[] range;
        if(rowGroup == 0) {
            if(colGroup == 0) {
                range = new int[]{0, 2, 0, 2};
            } else if(colGroup == 1) {
                range = new int[]{0, 2, 3, 5};
            } else {
                range = new int[]{0, 2, 6, 8};
            }
        } else if(rowGroup == 1) {
            if(colGroup == 0) {
                range = new int[]{3, 5, 0, 2};
            } else if(colGroup == 1) {
                range = new int[]{3, 5, 3, 5};
            } else {
                range = new int[]{3, 5, 6, 8};
            }
        } else {
            if(colGroup == 0) {
                range = new int[]{6, 8, 0, 2};
            } else if(colGroup == 1) {
                range = new int[]{6, 8, 3, 5};
            } else {
                range = new int[]{6, 8, 6, 8};
            }
        }

        // check in the specific 3 x 3 grid
        for(int i=range[0]; i<=range[1]; i++) {
            for(int j=range[2]; j<=range[3]; j++) {
                if(i == row && j == col) {
                    continue;
                }
                if(grid[i][j] == num) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean helper(int[][] grid, int row, int col, ArrayList<Integer> numList) {
        // base case, if col goes out of grid
        if(col == 9) {
            return helper(grid, row + 1, 0, new ArrayList<>());
        }

        // base case, if row goes out of grid
        if(row == 9) {
            return true;
        }

        // if current position holds a number initially
        if(grid[row][col] != 0) {
            // if number at current position is present either in that row or column
            if(numList.contains(grid[row][col]) || isColumnUnsafe(grid, row, col, grid[row][col])
                    || isMinGridUnsafe(grid, row, col, grid[row][col])) {
                return false;
            }
            // else move forward
            numList.add(grid[row][col]);
            boolean res = helper(grid, row, col + 1, numList);
            numList.remove(numList.size() - 1); // backtracking step
            return res;
        }

        // current position in grid is empty, try to fill it with a number between 1 and 9
        for(int i=1; i<10; i++) {
            // current row or column already has i at some position
            if(numList.contains(i) || isColumnUnsafe(grid, row, col, i) || isMinGridUnsafe(grid, row, col, i)) {
                continue;
            }

            // put i at current position and call recursively for rest
            grid[row][col] = i;
            numList.add(i);
            boolean res = helper(grid, row, col + 1, numList);
            if(res) {
                return true;
            }

            // backtracking steps if current solution fails
            numList.remove(numList.size() - 1);
            grid[row][col] = 0;
        }

        return false;
    }

    public static boolean canSolve(int[][] grid) {
        return helper(grid, 0, 0, new ArrayList<>());
    }

    private static void printGrid(int[][] grid) {
        for(int[] i: grid) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        System.out.println(canSolve(grid));
        printGrid(grid);
    }
}
