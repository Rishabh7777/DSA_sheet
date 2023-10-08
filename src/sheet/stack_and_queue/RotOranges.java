package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class RotOranges {
    // to hold 2-D array indices
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        // store all indices that has rotten orange
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
            }
        }

        // insert a delimiter into queue to check each stage of BFS
        if(!q.isEmpty()) {
            q.add(new Pair(-1, -1));
        }
        int count = 0;
        boolean flag = false; // to record any update in the grid

        // pick index from queue one-by-one and rotten all oranges nearby it
        while(!q.isEmpty()) {
            Pair p = q.remove();

            if(p.x > 0 && grid[p.x-1][p.y] == 1) {
                grid[p.x-1][p.y] = 2;
                q.add(new Pair(p.x-1, p.y));
                flag = true;
            }
            if(p.y < grid[0].length-1 && grid[p.x][p.y+1] == 1) {
                grid[p.x][p.y+1] = 2;
                q.add(new Pair(p.x, p.y+1));
                flag = true;
            }
            if(p.x < grid.length-1 && grid[p.x+1][p.y] == 1) {
                grid[p.x+1][p.y] = 2;
                q.add(new Pair(p.x+1, p.y));
                flag = true;
            }
            if(p.y > 0 && grid[p.x][p.y-1] == 1) {
                grid[p.x][p.y-1] = 2;
                q.add(new Pair(p.x, p.y-1));
                flag = true;
            }

            if(!q.isEmpty() && q.peek().x == -1) {
                q.remove();
                if(flag) {
                    count++;
                    flag = false;
                }
                if(!q.isEmpty()) {
                    q.add(new Pair(-1, -1));
                }
            }
        }

        // now if queue becomes empty then no more oranges can be rotten
        // so check if there is any non-rotten orange present
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }
}
