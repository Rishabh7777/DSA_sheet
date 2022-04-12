package sheet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    private static int sol(String s, int pos, List<String> dict, int[] dp) {
        //base case, when complete s is traversed
        //empty string is word break already
        if(pos == s.length()+1) {
            return 1;
        }

        if(dp[pos-1] != -1) {
            return dp[pos-1];
        }

        //find a substring in s which is present in dict,
        //and check for the rest string
        for(int i=pos; i<=s.length(); i++) {
            if(dict.contains(s.substring(pos-1, i)) && sol(s, i+1, dict, dp) == 1) {
                dp[pos-1] = 1;
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "mango";
        List<String> dict = new ArrayList<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile",
          "ice","cream", "icecream", "man", "go", "mango"));

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        System.out.println(sol(s,1, dict, dp));
    }
}
