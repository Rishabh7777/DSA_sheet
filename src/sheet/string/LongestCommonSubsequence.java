package sheet.string;

import java.util.Arrays;

public class LongestCommonSubsequence {
    private static int findCommSeq(String str1, int curr1, String str2, int curr2, int[][] dp) {
        if(curr1 == str1.length() || curr2 == str2.length()) {
            return 0;
        }

        if(dp[curr1][curr2] != -1) {
            return dp[curr1][curr2];
        }

        if(str1.charAt(curr1) == str2.charAt(curr2)) {
            return dp[curr1][curr2] = 1+findCommSeq(str1, curr1+1, str2, curr2+1, dp);
        } else {
            int left = findCommSeq(str1, curr1+1, str2, curr2, dp);
            int right = findCommSeq(str1, curr1, str2, curr2+1, dp);
            return dp[curr1][curr2] = Math.max(left, right);
        }
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        return findCommSeq(text1, 0, text2, 0, dp);
    }

    public static void main(String[] args) {
        String s1 = "gigummcnu";
        String s2 = "gigummcnu";
        System.out.println(longestCommonSubsequence(s1, s2));
    }
}
