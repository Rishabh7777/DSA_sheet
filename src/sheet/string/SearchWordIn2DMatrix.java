package sheet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchWordIn2DMatrix {
    private static int[][] searchWord(char[][] grid, String word) {
        List<int[]> res = new ArrayList<>();

        //for moving in a direction
        int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1}; //for changing row
        int[] dy = {0, 1, 0, -1, 1, 1, -1, -1}; //for changing column

        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                //find a location in grid which matches with first char in word
                if(grid[row][col] != word.charAt(0)) {
                    continue;
                }

                //select a direction at a time
                for(int dir=0; dir<8; dir++) {
                    int r = row + dx[dir];
                    int c = col + dy[dir];
                    int k = 1; //to traverse the word

                    //now traverse the whole word and check if each char matches in one single direction
                    while(k < word.length()) {
                        //check if current position is inside grid
                        //and the respective chars match
                        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || word.charAt(k) != grid[r][c]) {
                            break;
                        }

                        r += dx[dir];
                        c += dy[dir];
                        k++;
                    }

                    //found the word in grid
                    if(k == word.length()) {
                        res.add(new int[]{row, col});
                        break;
                    }
                }
            }
        }

        //make a matrix from res and return it
        int[][] arr = new int[res.size()][2];
        int k = 0;
        for(int[] i: res) {
            arr[k] = i;
            k++;
        }

        return arr;
    } //O(n^2 * 8 * len(word)) = O(n^2)

    public static void main(String[] args) {
        char[][] grid = {{'a'}};
        String word = "ab";
        int[][] res = searchWord(grid, word);

        for(int[] i: res) {
            System.out.println(Arrays.toString(i));
        }
    }
}
