package sheet.backtracking;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    private static int helper(int[] arr, int n, int sum, int[][] dp) {
        // base cases
        if(sum == 0) {
            return 1;
        }
        if(n == 0) {
            return 0;
        }

        // check if previously visited situation
        if(dp[n-1][sum] != -1) {
            return dp[n-1][sum];
        }

        // if current value exceeds sum then it can only be excluded
        if(arr[n-1] > sum) {
            return dp[n-1][sum] = helper(arr, n-1, sum, dp);
        }

        // include current value in sum
        int inc = helper(arr, n-1, sum-arr[n-1], dp);
        if(inc == 1) {
            return dp[n-1][sum] = 1;
        }

        // exclude current value
        int exc = helper(arr, n-1, sum, dp);
        if(exc == 1) {
            return dp[n-1][sum] = 1;
        }
        return dp[n-1][sum] = 0;
    }

    public static int equalPartition(int n, int[] arr) {
        int totalSum = 0;
        for(int i: arr) {
            totalSum += i;
        }

        // if sum of array is odd, partition is not possible
        if(totalSum % 2 != 0) {
            return 0;
        }

        int[][] dp = new int[n][totalSum];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        return helper(arr, n, totalSum/2, dp);
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 5, 11, 5};
        System.out.println(equalPartition(n, arr));

        n = 3;
        arr = new int[]{1, 3, 5};
        System.out.println(equalPartition(n, arr));
    }
}
