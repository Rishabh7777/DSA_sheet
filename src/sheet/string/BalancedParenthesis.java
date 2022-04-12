package sheet.string;

import java.util.Stack;

public class BalancedParenthesis {
    private static boolean sol(String s) {
        Stack<Character> stack = new Stack<>();

        //loop through s
        //push opening brackets into stack and pop them if same closing bracket found
        //if brackets mismatch then return false
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
                continue;
            }

            char c = s.charAt(i);
            //stack may give empty stack exception
            char p = stack.isEmpty() ? 'q' : stack.peek();
            if((c == ')' && p == '(') || (c == '}' && p == '{') || (c == ']' && p == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})";
        System.out.println(sol(s));
    }
}
