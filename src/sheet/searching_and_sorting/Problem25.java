package sheet.searching_and_sorting;

public class Problem25 {
    private static boolean canRead(int[] books, int N, int maxCap, int M) {
        int stuCnt = 1;
        int cntPages = 0;

        for(int i=0; i<N;) {
            if(stuCnt > M) {
                return false;
            }
            if(cntPages + books[i] <= maxCap) {
                cntPages += books[i++];
            } else {
                stuCnt++;
                cntPages = 0;
            }
        }

        return true;
    }

    //using binary search
    public static int findPages(int[] A, int N, int M) {
        int r = 0; //total number of pages to read
        for(int i: A) {
            r += i;
        }

        int l = 0;
        while(r > l) {
            int mid = l + (r - l)/2; //maximum number of pages that one person will read
            if(canRead(A, N, mid, M)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        int N = 4, M = 2;
        int[] arr = {10, 20, 30, 40};
        System.out.println(findPages(arr, N, M));
    }
}
