package sheet.greedy;

import java.util.Arrays;

public class MaxSumAfterKNegations {
    public static long maximizeSum(long[] a, int n, int k) {
        //sort the array first, so that numbers with greater absolute value made +ve first
        Arrays.sort(a);
        //turn all the -ve numbers into +ve
        for(int i=0; i<n; i++) {
            if(a[i] < 0 && k > 0) {
                a[i] = -a[i];
                k--;
            }
        }
        //if K is still greater than 0, then a[] contains only +ve numbers
        if(k > 0) {
            Arrays.sort(a);
            while(k > 0) {
                a[0] = -a[0];
                k--;
            }
        }
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5, k = 5;
        long[] arr = {1,2,3,4,5};
        System.out.println(maximizeSum(arr, n, k));
    }
}
