package sheet.matrix;

public class RowWithMaxOne {
    private static int sol(int[][] arr, int n, int m) {
        int cnt = m, rowIdx = n, rowCnt = 0;
        for(int[] row: arr) {
            int low = 0, high = m;
            while(low < high) {
                int mid = (low + high) / 2;
                if(row[mid] == 1) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if(low < cnt) {
                cnt = low;
                rowIdx = rowCnt;
            }
            System.out.println("cnt = " + cnt);
            rowCnt++;
        }
        return (rowIdx == n) ? -1 : rowIdx;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1,1,1}, {0,0,1,1}, {0,1,1,1}, {0,0,0,0}};
        int n = 4, m = 4;
        System.out.println(sol(arr, n, m));
    }
}
