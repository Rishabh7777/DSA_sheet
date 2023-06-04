package sheet.backtracking;

import java.util.ArrayList;

public class PalindromicPartitions {
    private static boolean isPalindromic(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static void helper(String s, ArrayList<String> list, ArrayList<ArrayList<String>> res) {
        // base case
        if(s.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // loop on s and check every possible partition is palindrome or not
        for(int i=1; i<=s.length(); i++) {
            if(isPalindromic(s.substring(0, i))) {
                list.add(s.substring(0, i));
                helper(s.substring(i), list, res);
                // backtracking steps
                list.remove(list.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        helper(s, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        String s = "geeks";
        System.out.println(allPalindromicPerms(s));

        s = "madam";
        System.out.println(allPalindromicPerms(s));
    }
}
