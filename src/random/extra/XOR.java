package random.extra;

import java.util.Arrays;

public class XOR {
    private static int sol(int[] arr, int n, int curr, int count, int[] dp) {
        if(curr >= n || count == n/2) {
            return 0;
        }
        int inc = arr[curr] ^ sol(arr, n, curr+1, count+1, dp);
        int exc = sol(arr, n, curr+1, count, dp);
        return dp[curr] = Math.max(inc, exc);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        System.out.println(sol(arr, 4, 0, 0, dp));
    }
}
