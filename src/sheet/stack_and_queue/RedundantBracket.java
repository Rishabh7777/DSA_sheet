package sheet.stack_and_queue;

import java.util.Stack;

public class RedundantBracket {
    public static String isBracketRedundant(String str) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else if(ch == ')') {
                boolean operatorFound = false;
                while(st.peek() != '(') {
                    char c = st.pop();
                    if(c == '+' || c == '-' || c == '*' || c == '/') {
                        operatorFound = true;
                    }
                }
                if(!operatorFound) {
                    return "Yes";
                }
                st.pop();
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        String str = "(a*b+(c/d))";
        System.out.println(isBracketRedundant(str));
    }
}
