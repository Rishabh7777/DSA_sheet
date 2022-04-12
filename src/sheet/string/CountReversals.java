package sheet.string;

import java.util.Stack;

public class CountReversals {
    private static int sol(String s) {
        Stack<Character> st = new Stack<>();
        int rev = 0;

        for(int i=0; i<s.length(); i++) {
            if(st.isEmpty()) {
                st.push(s.charAt(i));
            } else if(st.peek() == '{' && s.charAt(i) == '}') {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        //after this traversal, stack only contains number of parenthesis that making string imbalanced

        //odd number of imbalanced parenthesis cannot be balanced
        if(st.size() % 2 != 0) {
            return -1;
        }

        while(!st.isEmpty()) {
            char temp1 = st.pop();
            char temp2 = st.pop();

            if(temp1 == temp2) {
                rev++; //only one of them needed to be changed
            } else {
                rev += 2;
            }
        }

        return rev;
    }

    public static void main(String[] args) {
        String s = "{{}{{{}{{}}{{";
        System.out.println(sol(s));
    }
}
