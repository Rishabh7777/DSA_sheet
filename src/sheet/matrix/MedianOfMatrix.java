package sheet.matrix;

public class MedianOfMatrix {
    private static int median(int[][] matrix, int r, int c) {
        int low = 1, high = 2000;
        while(low <= high) {
            int mid = (low + high) / 2;
            int num = 0;

            //search for no. of elements <=mid in matrix
            for(int i=0; i<r; i++) {
                int l = 0, h = c-1;
                while(l <= h) {
                    int m = (l + h) / 2;
                    if(matrix[i][m] <= mid) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                }
                num += l; //no. of elements on left of mid
            }

            //num should point to median
            int half = (r * c) / 2;
            if(num <= half) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {2}, {3}};
        System.out.println(median(matrix, 3, 1));
    }
}
