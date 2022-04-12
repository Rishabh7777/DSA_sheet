package sheet.string;

import java.util.Arrays;

//given a string and a pattern with wildcard characters '*' and '?'
//return true if string match with pattern else return false
public class Problem39 {
    private static int helper(String text, String pat, int currT, int currP, int[][] dp) {
        //base cases
        if(currT == text.length() && currP == pat.length()) {
            return 1; //both pointers passed the whole strings
        }
        if(currT == text.length() || currP == pat.length()) {
            return 0; //only one pointer passed the whole string
        }

        if(dp[currT][currP] != -1) {
            return dp[currT][currP];
        }

        //? -> can match any char in string
        //* -> can match zero or more chars in string
        if(text.charAt(currT) == pat.charAt(currP) || pat.charAt(currP) == '?') {
            return dp[currT][currP] = helper(text, pat, currT+1, currP+1, dp);
        }

        if(pat.charAt(currP) == '*') {
            int incBoth = helper(text, pat, currT+1, currP+1, dp);
            if(incBoth == 1) {
                return dp[currT][currP] = 1;
            }
            int incT = helper(text, pat, currT+1, currP, dp);
            if(incT == 1) {
                return dp[currT][currP] = 1;
            }
            int incP = helper(text, pat, currT, currP+1, dp);
            return dp[currT][currP] = incP == 1 ? 1 : 0;
        }

        return dp[currT][currP] = 0;
    }

    private static int sol(String text, String pat) {
        int len = pat.length();
        if(text.length() > pat.length()) {
            len = text.length();
        }
        int[][] dp = new int[len][len];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        pat = pat.replaceAll("\\*+", "*");

        return helper(text, pat, 0, 0, dp);
    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pat = "***ba*?**ab";
        System.out.println(sol(text, pat));
    }
}
