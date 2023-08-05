package sheet.stack_and_queue;

import java.util.Stack;

public class InsertAtBottom {
    private static Stack<Integer> st;

    private static void insertAtBottom(int num) {
        if(st.isEmpty()) {
            st.push(num);
        } else {
            int top = st.pop();
            insertAtBottom(num);
            st.push(top);
        }
    }

    public static void main(String[] args) {
        st = new Stack<>();
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        insertAtBottom(10);

        while(!st.isEmpty()) {
            System.out.print(st.pop() + " --> ");
        }
        System.out.println("Empty");
    }
}
