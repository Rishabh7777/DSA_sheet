package sheet.string;

public class WordWrap {
    private static int sol(int[] l, int n, int M) {
        //extras[i][j] will have number of extra spaces if words from i to j are put in a single line
        int[][] extras = new int[n+1][n+1];
        //lc[i][j] will have cost of putting words from i to j in a single line
        int[][] lc = new int[n+1][n+1];
        //c[i] will have effective cost of optimal arrangement of words from 1 to i
        int[] c = new int[n+1];

        for (int i = 1; i <= n; i++) {
            extras[i][i] = M - l[i-1];
            for (int j = i+1; j <= n; j++)
                extras[i][j] = extras[i][j-1] - l[j-1] - 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (extras[i][j] < 0)
                    lc[i][j] = Integer.MAX_VALUE;
                else if (j == n && extras[i][j] >= 0)
                    lc[i][j] = 0;
                else
                    lc[i][j] = extras[i][j]*extras[i][j];
            }
        }

        c[0] = 0;
        for (int j = 1; j <= n; j++) {
            c[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                if (c[i-1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE && (c[i-1] + lc[i][j] < c[j])) {
                    c[j] = c[i-1] + lc[i][j];
                }
            }
        }

        return c[n];
    }

    public static void main(String[] args) {
        int[] wordLength = {3, 2, 2};
        int maxChar = 4;

        System.out.println(sol(wordLength, wordLength.length, maxChar));
    }
}
