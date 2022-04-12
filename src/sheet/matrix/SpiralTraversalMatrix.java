package sheet.matrix;

import java.util.ArrayList;

public class SpiralTraversalMatrix {

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> res = new ArrayList<>();
        int startR = 0, startC = 0;

        while (startR < r && startC < c) {
            for (int i = startC; i < c; i++) {
              res.add(matrix[startR][i]);
            }
            startR++;

            for (int i = startR; i < r; i++) {
              res.add(matrix[i][c - 1]);
            }
            c--;

            if(startR < r) {
                for (int i = c - 1; i >= startC; i--) {
                    res.add(matrix[r - 1][i]);
                }
                r--;
            }

            if(startC < c) {
                for (int i = r - 1; i >= startR; i--) {
                    res.add(matrix[i][startC]);
                }
                startC++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        spirallyTraverse(matrix, 3, 4);
    }
}
