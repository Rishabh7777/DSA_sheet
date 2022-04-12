package sheet.string;

import java.util.Arrays;

public class EditDistance {
    //the process will not make any changes to s or target strings
    private static int sol(String s, int p1, String target, int p2, int[][] dp) {
        //base cases
        if(p1 == s.length()) {
            return target.length() - p2;
        }
        if(p2 == target.length()) {
            return s.length() - p1;
        }

        if(dp[p1][p2] != -1) {
            return dp[p1][p2];
        }

        //when chars at p1 and p2 are same, no need for any operation
        if(s.charAt(p1) == target.charAt(p2)) {
            return sol(s, p1+1, target, p2+1, dp);
        }

        //if chars do not match, perform insert, remove and replace operations
        //insert required char from target into s
        int insert = sol(s, p1, target, p2+1, dp);

        //replace char at p1 with char at p2
        int replace = sol(s, p1+1, target, p2+1, dp);

        //remove char at p1
        int remove = sol(s, p1+1, target, p2, dp);

        //return minimum number of operations performed to match the strings
        return dp[p1][p2] = 1 + Math.min(insert, Math.min(replace, remove));
    }

    public static void main(String[] args) {
        String s = "intention";
        String target = "execution";

        int[][] dp = new int[s.length()][target.length()];
        for(int[] i: dp) {
            Arrays.fill(i, -1);
        }

        System.out.println(sol(s, 0, target, 0, dp));
    }
}
