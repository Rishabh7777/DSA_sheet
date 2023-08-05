package sheet.stack_and_queue;

import java.util.Stack;

public class EvaluatePostfix {
    public static int evaluatePostFix(String S) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(Integer.parseInt(String.valueOf(c)));
            } else {
                int a = st.pop();
                int b = -1;
                if(!st.isEmpty()) {
                    b = st.pop();
                } else {
                    return a;
                }
                int res = 0;
                if(c == '*') {
                    res = a * b;
                } else if(c == '/') {
                    res = b / a;
                } else if(c == '+') {
                    res = a + b;
                } else if(c == '-') {
                    res = b - a;
                }
                st.push(res);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String str = "231*+9-";
        System.out.println(evaluatePostFix(str));
    }
}
