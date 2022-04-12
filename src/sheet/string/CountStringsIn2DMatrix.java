package sheet.string;

public class CountStringsIn2DMatrix {

    private static int sol(char[][] grid, int cr, int cc, String word, int k, boolean[][] vis) {
        //cr and cc does not point in grid
        //or char does not match
        //or char is already visited
        if(cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length || vis[cr][cc]
                || grid[cr][cc] != word.charAt(k)) {
            return 0;
        }

        //found the word in grid
        if(k == word.length()-1) {
            return 1;
        }

        //recursively call in all four directions
        vis[cr][cc] = true;
        int up = sol(grid, cr-1, cc, word, k+1, vis); //moving up
        int down = sol(grid, cr+1, cc, word, k+1, vis); //moving down
        int left = sol(grid, cr, cc-1, word, k+1, vis); //moving left
        int right = sol(grid, cr, cc+1, word, k+1, vis); //moving right
        vis[cr][cc] = false; //backtracking step

        return Math.max(up, Math.max(down, Math.max(left, right)));
    }

    public static int findCount(char[][] grid, String word) {
        //check for all chars in grid which can possibly be first char of word
        int res = 0;
        boolean[][] vis;

        for (int row=0; row<grid.length; row++) {
            for (int col=0; col < grid[0].length; col++) {
                if (word.charAt(0) == grid[row][col]) {
                    vis = new boolean[grid.length][grid[0].length];
                    res += sol(grid, row, col, word, 0, vis);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {{'B','B','M','B','B','B'}, {'C','B','A','B','B','B'}, {'I','B','G','B','B','B'},
                {'G','B','I','B','B','B'}, {'A','B','C','B','B','B'}, {'M','C','I','G','A','M'}};
        String word = "MAGIC";

        System.out.println(findCount(grid, word));
    }
}