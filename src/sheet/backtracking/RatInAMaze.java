package sheet.backtracking;

import java.util.ArrayList;

public class RatInAMaze {
    private static void helper(int cr, int cc, int n, String path, int[][] maze, ArrayList<String> allPath) {
        // if we move outside of maze
        if(cr < 0 || cr >= n || cc < 0 || cc >= n) {
            return;
        }

        // maze[cr][cc] = 0 -> path is blocked
        if(maze[cr][cc] == 0 || maze[cr][cc] == -1) {
            return;
        }

        // if we reached the last cell of maze
        if(cr == n-1 && cc == n-1) {
            allPath.add(path);
        }

        // mark the current cell to not visit it again
        maze[cr][cc] = -1;

        // try to move in all possible directions with recursive calls
        helper(cr + 1, cc, n, path + "D", maze, allPath); // move down
        helper(cr, cc - 1, n, path + "L", maze, allPath); // move left
        helper(cr - 1, cc, n, path + "U", maze, allPath); // move top
        helper(cr, cc + 1, n, path + "R", maze, allPath); // move right

        // backtrack step, mark current cell as 1 again to include it in other paths
        maze[cr][cc] = 1;
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> allPath = new ArrayList<>();
        helper(0, 0, n, "", m, allPath);
        return allPath;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPath(maze, n));

        n = 2;
        maze = new int[][]{{1, 0}, {1, 0}};
        System.out.println(findPath(maze, n));
    }
}
