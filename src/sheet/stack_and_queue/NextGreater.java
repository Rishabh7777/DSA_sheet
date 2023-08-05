package sheet.stack_and_queue;

import java.util.Stack;

public class NextGreater {
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        st.push(-1L);

        for(int i=n-1; i>=0; i--) {
            while(st.peek() != -1 && st.peek() <= arr[i]) {
                st.pop();
            }
            long val = st.peek();
            st.push(arr[i]);
            arr[i] = val;
        }

        return arr;
    }
}
