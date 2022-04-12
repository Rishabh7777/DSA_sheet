package sheet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
    private static List<String> res; //to store all permutations of string

    private static void sol(char[] s, int curr) {
        //if there are no more swaps to perform
        if(curr == s.length-1) {
            res.add(String.valueOf(s)); //current structure of s is one permutation
            return;
        }

        //all chars before curr are fixed, swaps will be performed from curr
        for(int i=curr; i<s.length; i++) {
            //swap chars at i and curr
            char temp = s[i];
            s[i] = s[curr];
            s[curr] = temp;

            //recursive call to find permutations from curr+1 and fixing curr char
            sol(s, curr+1);

            //reverse the swap performed above as arrays are built in heap
            //so recursive calls will not build new array with each recursive call
            temp = s[i];
            s[i] = s[curr];
            s[curr] = temp;
        } //O(n * n!)
    }

    private static List<String> findPermutations(String s) {
        res = new ArrayList<>();
        sol(s.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String s = "ABSG";
        System.out.println(Arrays.toString(findPermutations(s).toArray()));
        System.out.println(res.size());
    }
}
