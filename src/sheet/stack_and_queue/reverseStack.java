package sheet.stack_and_queue;

import java.util.Stack;

public class reverseStack {
    static void reverse(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        } else {
            int top = s.pop();
            reverse(s);
            insertAtBottom(s, top);
        }
    } // O(n^2)

    private static void insertAtBottom(Stack<Integer> st, int num) {
        if(st.isEmpty()) {
            st.push(num);
        } else {
            int top = st.pop();
            insertAtBottom(st, num);
            st.push(top);
        }
    } // O(n)

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(4);

        reverse(st);

        while(!st.isEmpty()) {
            System.out.print(st.pop() + " --> ");
        }
        System.out.println("Empty");
    }
}
