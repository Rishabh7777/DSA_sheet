package sheet.stack_and_queue;

import java.util.Stack;

public class sortStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty()) {
            return s;
        }
        int top = s.pop();
        sort(s);
        compareAndAdd(s, top);
        return s;
    }

    private static void compareAndAdd(Stack<Integer> s, int top) {
        if(s.isEmpty() || top >= s.peek()) {
            s.push(top);
        } else {
            int num = s.pop();
            compareAndAdd(s, top);
            s.push(num);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(41);
        st.push(3);
        st.push(32);
        st.push(2);
        st.push(11);

        sort(st);

        while(!st.isEmpty()) {
            System.out.print(st.pop() + " --> ");
        }
        System.out.println("Empty");
    }
}
