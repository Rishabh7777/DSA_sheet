package sheet.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestSubSetWithGreaterSum {
    public static int minSubset(int[] arr, int N) {
        Arrays.sort(arr);
        long total = 0;
        for(int i: arr) {
            total += i;
        }
        long sum1 = 0;
        int count = 0;
        for(int i=N-1; i>=0; i--) {
            sum1 += arr[i];
            if(sum1 > (total - sum1)) {
                count = N - i;
                break;
            }
        }
        return count == 0 ? N : count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 0, 1, 2};
        System.out.println(minSubset(arr, arr.length));
    }
}
