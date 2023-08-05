package sheet.stack_and_queue;

import java.util.Stack;

public class InfixToPostfix {
    private static int checkPrecedence(char c) {
        if(c == '+' || c == '-') {
            return 1;
        } else if(c == '*' || c == '/') {
            return 2;
        } else if(c == '^') {
            return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i=0; i<exp.length(); i++) {
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)) {
                res.append(c);
            } else if(c == '(') {
                st.push('(');
            } else if(c == ')') {
                while(st.peek() != '(') {
                    res.append(st.pop());
                }
                st.pop();
            } else {
                while(!st.isEmpty() && checkPrecedence(c) <= checkPrecedence(st.peek())) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }

        while(!st.isEmpty()) {
            if(st.peek() == '(') {
                return "Invalid Expression";
            }
            res.append(st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }
}
