package sheet.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DefendKingdom {
    public static int sol(int w, int h, int n, int[] x, int[] y) {
        if(n == 0) {
            return w * h;
        }
        Arrays.sort(x);
        Arrays.sort(y);
        //calculate difference between adjacent numbers in x[] and y[]
        int[] dx = new int[n+1];
        int[] dy = new int[n+1];
        dx[0] = x[0];
        int maxX = dx[0];
        dy[0] = y[0];
        int maxY = dy[0];
        for(int i=1; i<n; i++) {
            dx[i] = x[i] - x[i-1];
            maxX = Math.max(maxX, dx[i]);
            dy[i] = y[i] - y[i-1];
            maxY = Math.max(maxY, dy[i]);
        }
        dx[n] = w - x[n-1];
        maxX = Math.max(maxX, dx[n]);
        dy[n] = h - y[n-1];
        maxY = Math.max(maxY, dy[n]);
        //product of maxX-1 and maxY-1 will give max rectangle uncovered
        return (maxX - 1) * (maxY - 1);
    }

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=0; i<t; i++) {
            int w = scan.nextInt();
            int h = scan.nextInt();
            int n = scan.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for(int j=0; j<n; j++) {
                x[j] = scan.nextInt();
                y[j] = scan.nextInt();
            }
            System.out.println(sol(w, h, n, x, y));
        }
    }
}
