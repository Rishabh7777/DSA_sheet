package sheet.string;

import java.util.Arrays;

public class PalindromicSubsequence {
    private static final int m = (int)Math.pow(10, 9) + 7;

    private static long sol(String s, int start, int end, long[][] dp) {
        //base case
        if(start > end) {
            return 0;
        }
        if(start == end) {
            return 1;
        }

        //check if seen before
        if(dp[start][end] != -1) {
            return dp[start][end];
        }

        //if first and last char of s are same, then check for rest subsequence
        //current subsequence is palindrome
        if(s.charAt(start) == s.charAt(end)) {
            return dp[start][end] = (1 + sol(s, start+1, end, dp) + sol(s, start, end-1, dp)) % m;
        } else {
            return dp[start][end] = (sol(s, start+1, end, dp) + sol(s, start, end-1, dp)
                    - sol(s, start+1, end-1, dp)) % m;
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        long[][] dp = new long[s.length()][s.length()];
        for(long[] i: dp) {
            Arrays.fill(i, -1L);
        }
        System.out.println(sol(s, 0, s.length()-1, dp));
    }
}
