package sheet.stack_and_queue;

import java.util.Stack;

public class ValidSubstring {
    static int findMaxLen(String S) {
        if(S.length() == 1) {
            return 0;
        }

        Stack<Integer> st = new Stack<>();
        // keep track of indexes that acting as hurdles
        // not letting the S to be completely valid
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '(') {
                st.push(i);
            } else {
                if(!st.isEmpty() && S.charAt(st.peek()) == '(') {
                    st.pop();
                } else {
                    st.push(i);
                }
            }
        }

        int end = S.length();
        int max = 0;
        while(!st.isEmpty()) {
            int top = st.pop();
            max = Math.max(max, (end - top - 1));
            end = top;
        }

        // max = Math.max(max, (index - st.pop()));
        return Math.max(end, max);
    }
}
