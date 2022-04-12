package sheet.string;

import java.util.*;

public class AllSubsequences {
    private static Set<String> res;

    private static void sol(String s, int curr, String subSeq) {
        if(curr == s.length()) {
            if(!Objects.equals(subSeq, "")) {
                res.add(subSeq);
            }
            return;
        }

        sol(s, curr+1, subSeq+s.charAt(curr));
        sol(s, curr+1, subSeq);
    }

    public static void main(String[] args) {
        String s = "abcd";
        res = new HashSet<>();
        sol(s, 0, "");

        System.out.println(res.size());
        for(String curr: res) {
            System.out.print(curr + ", ");
        }
    }
}
