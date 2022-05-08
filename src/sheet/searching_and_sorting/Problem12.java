package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem12 {
    private static int helper(int[] arr, int n, int curr, int[] dp) {
        if(curr >= n) {
            return 0;
        }

        if(dp[curr] != -1) {
            return dp[curr];
        }

        int inc = arr[curr] + helper(arr, n, curr + 2, dp);
        int exc = helper(arr, n, curr + 1, dp);

        return dp[curr] = Math.max(inc, exc);
    }

    public int FindMaxSum(int[] arr, int n) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, n, 0, dp);
    }
}
