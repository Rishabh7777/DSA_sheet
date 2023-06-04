package sheet.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationsOfString {
    private static void sol(char[] s, int curr, List<String> res) {
        // if there are no more swaps to perform
        if(curr == s.length-1) {
            res.add(String.valueOf(s)); //current structure of s is one permutation
            return;
        }

        // all chars before curr are fixed, swaps will be performed from curr
        for(int i=curr; i<s.length; i++) {
            //swap chars at i and curr
            char temp = s[i];
            s[i] = s[curr];
            s[curr] = temp;

            // recursive call to find permutations from curr+1 and fixing curr char
            sol(s, curr + 1, res);

            // reverse the swap performed above as arrays are built in heap
            // so recursive calls will not build new array with each recursive call
            temp = s[i];
            s[i] = s[curr];
            s[curr] = temp;
        }
    }

    public static List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        sol(S.toCharArray(), 0, res);
        // sort the res to get lexicographic order
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String s = "ABSG";
        List<String> res = find_permutation(s);
        System.out.println("Total permutations = " + res.size());
        System.out.println(res);

        s = "ABC";
        res = find_permutation(s);
        System.out.println("Total permutations = " + res.size());
        System.out.println(res);
    }
}
