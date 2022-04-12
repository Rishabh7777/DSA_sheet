package sheet.matrix;

import java.util.Arrays;

public class SortedMatrix {
    private  static int[][] sortedMatrix(int N, int Mat[][]) {
        int[] arr = new int[N * N];
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr[count] = Mat[i][j];
                count++;
            }
        }

        Arrays.sort(arr);

        count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                Mat[i][j] = arr[count];
                count++;
            }
        }

        return Mat;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] Mat = {{10,20,30,40}, {15,25,35,45}, {27,29,37,48}, {32,33,39,50}};
        sortedMatrix(N, Mat);
    }
}
