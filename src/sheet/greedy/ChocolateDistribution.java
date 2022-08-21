package sheet.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistribution {
    public static long findMinDiff (ArrayList<Long> a, long n, long m) {
        Collections.sort(a);
        long minDiff = Long.MAX_VALUE;
        int reach = (int)(n-m);
        for(int i=0; i<=reach; i++) {
            long min = a.get(i);
            long max = a.get(i+(int)m-1);
            minDiff = Math.min(minDiff, (max - min));
        }
        return minDiff;
    }

    public static void main(String[] args) {
        long n = 8, m = 5;
        ArrayList<Long> aL = new ArrayList<>(Arrays.asList(3L, 4L, 1L, 9L, 56L, 7L, 9L, 12L));
        System.out.println(findMinDiff(aL, n, m));
    }
}
