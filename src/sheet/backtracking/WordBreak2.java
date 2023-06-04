package sheet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak2 {
    private static boolean isValidWord(List<String> dict, int start, int end, String s) {
        String sub = s.substring(start, end);
        return dict.contains(sub);
    }

    private static void helper(List<String> dict, String s, int len, int curr, List<String> res, StringBuilder valid) {
        // base case
        if(s.substring(curr).isEmpty()) {
            res.add(valid.toString());
            return;
        }
        // loop from curr to length of s to find valid words
        for(int i=curr; i<=len; i++) {
            if(isValidWord(dict, curr, i, s)) {
                // if a valid word is found on left of string s[curr...len]
                if(valid.length() != 0) {
                    valid.append(" ");
                }
                valid.append(s, curr, i);
                // call recursively for right part of partition in s
                helper(dict, s, len, i, res, valid);
                // backtracking step, remove added substring in valid
                int j = valid.length() - 1;
                while(j > 0 && valid.charAt(j) != ' ') {
                    valid.deleteCharAt(j);
                    j--;
                }
                valid.deleteCharAt(j);
            }
        }
    }

    public static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> res = new ArrayList<>();
        StringBuilder valid = new StringBuilder();
        helper(dict, s, s.length(), 0, res, valid);
        return res;
    }

    public static void main(String[] args) {
        String s = "ewneewnewnesqmgb";
        int n = 5;
        List<String> dict = Arrays.asList("wn", "e", "wne", "sqmgb", "q");
        System.out.println(wordBreak(n, dict, s));
    }
}
