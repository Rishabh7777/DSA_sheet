package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] nearest(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> init = new LinkedList<>();

        // get all positions which have 1
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    init.add(new Pair(i, j));
                }
            }
        }

        // insert a delimiter at queue end to know levels of BFS
        q.add(new Pair(-1, -1));
        int counter = 1;

        while(!q.isEmpty()) {
            Pair p = q.remove();

            // replace all 0's with 1's near p
            if(p.x > 0 && grid[p.x-1][p.y] == 0) {
                grid[p.x-1][p.y] = counter;
                q.add(new Pair(p.x-1, p.y));
            }
            if(p.y < grid[0].length-1 && grid[p.x][p.y+1] == 0) {
                grid[p.x][p.y+1] = counter;
                q.add(new Pair(p.x, p.y+1));
            }
            if(p.x < grid.length-1 && grid[p.x+1][p.y] == 0) {
                grid[p.x+1][p.y] = counter;
                q.add(new Pair(p.x+1, p.y));
            }
            if(p.y > 0 && grid[p.x][p.y-1] == 0) {
                grid[p.x][p.y-1] = counter;
                q.add(new Pair(p.x, p.y-1));
            }

            // if next pair in queue is delimiter
            // remove it and insert again if queue is non-empty
            if(!q.isEmpty() && q.peek().x == -1) {
                Pair del = q.remove();
                if(!q.isEmpty()) {
                    q.add(del);
                    counter++;
                }
            }
        }

        // convert all initial 1's to 0' from queue init
        while(!init.isEmpty()) {
            Pair p = init.remove();
            grid[p.x][p.y] = 0;
        }

        return grid;
    }
}
