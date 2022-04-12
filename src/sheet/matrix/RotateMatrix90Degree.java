package sheet.matrix;

public class RotateMatrix90Degree {
    private static int[][] rotate(int n, int[][] matrix) {
        // rotate with respect to main diagonal
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // rotate with respect to middle column
        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }

        return matrix;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int n = 4;

        matrix = rotate(n, matrix);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
