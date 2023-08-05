package sheet.stack_and_queue;

import java.util.Stack;

public class ReverseString {
    public String reverse(String S) {
        Stack<Character> st = new Stack<>();

        // push each character from starting into stack
        // then pop one by one and create a string from start
        for(int i=0; i<S.length(); i++) {
            st.push(S.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    } // O(n)

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        System.out.println(obj.reverse("GeeksforGeeks"));
    }
}
