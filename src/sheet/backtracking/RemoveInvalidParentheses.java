package sheet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    private static void helper(String s, int curr, int op, int cp, StringBuilder sb, List<String> res, int count) {
        // base case, if s is finished
        if(curr == s.length()) {
            if(op == cp && count == 0 && !res.contains(sb.toString())) {
                res.add(sb.toString());
            }
            return;
        }

        // if found an impaired ')' parentheses
        if(cp > op) {
            return;
        }

        // any char other than ')' or '(' must be added in result
        if(s.charAt(curr) != ')' && s.charAt(curr) != '(') {
            helper(s, curr+1, op, cp, sb.append(s.charAt(curr)), res, count);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        if(s.charAt(curr) == ')') {
            // recursive call including current char
            helper(s, curr + 1, op, cp + 1, sb.append(")"), res, count);
            // remove added char from sb
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // recursive call including current char
            helper(s, curr + 1, op + 1, cp, sb.append("("), res, count);
            // remove added char from sb
            sb.deleteCharAt(sb.length() - 1);
        }
        // recursive call excluding current char
        if(count > 0) {
            helper(s, curr + 1, op, cp, sb, res, count - 1);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        // count the minimum number of removals required
        int p = 0, count = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                p++;
            } else if(c == ')') {
                p--;
            }
            if(p < 0) {
                count++;
                p = 0;
            }
        }
        if(p > 0) {
            count += p;
        }

        List<String> res = new ArrayList<>();
        helper(s, 0, 0, 0, new StringBuilder(), res, count);
        return res;
    }

    public static void main(String[] args) {
        String s = ")(()";
        System.out.println(removeInvalidParentheses(s));

        s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }
}
