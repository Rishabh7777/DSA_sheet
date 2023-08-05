package sheet.stack_and_queue;

import java.util.Stack;

public class StackPermutations {
    // push elements from ip[] into stack one by one and in the same time if stack top matches current element
    // pointed by index in op[] then keep popping from stack
    public static int isStackPermutation(int n, int[] ip, int[] op) {
        int index = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            st.push(ip[i]);
            while(!st.isEmpty() && st.peek() == op[index]) {
                index++;
                st.pop();
            }
        }
        return (st.size() == 0) ? 1 : 0;
    }
}
