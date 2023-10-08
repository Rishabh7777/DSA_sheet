package sheet.stack_and_queue;

import java.util.Stack;

public class NextSmaller {
    public static int[] help_classmate(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for(int i=1; i<n; i++) {
            int val = arr[i];
            while(!st.isEmpty() && val < arr[st.peek()]) {
                res[st.peek()] = val;
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            res[st.pop()] = -1;
        }

        return res;
    } // O(n)
}
