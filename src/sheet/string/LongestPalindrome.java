package sheet.string;

public class LongestPalindrome {
    private static String sol(String s) {
        int len = s.length();
        int start = 0, end = 1; //holding result substring
        int maxLength = 1;

        boolean[][] dp = new boolean[len][len];
        // fill dp for strings of length == 1 and 2
        for(int i=0; i<len; i++) {
            dp[i][i] = true;
        }
        for(int i=1; i<len; i++) {
            dp[i-1][i] = s.charAt(i-1) == s.charAt(i);
            if(dp[i-1][i] && maxLength == 1) {
                start = i - 1;
                end = i + 1;
                maxLength = 2;
            }
        }

        // loop s
        // fill dp length wise, fill for different substrings of length == 3 first, then of length == 4 and so on
        for(int i=3; i<=len; i++) { // i -> width of substrings
            for(int j=0; j<=len-i; j++) { // j -> starting index of each substring
                int endIdx = j + i; // of each substring
                if(s.charAt(j) == s.charAt(endIdx-1) && dp[j+1][endIdx-2]) {
                    dp[j][endIdx-1] = true;
                    // if curr string length is greater than previous found
                    if(i > maxLength) {
                        maxLength = i;
                        start = j;
                        end = endIdx;
                    }
                }
            }
        }

        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(sol(s));
    }
}
