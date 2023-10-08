package sheet.stack_and_queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKInQueue {
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        int i = 0, size = q.size();
        while(i < k && !q.isEmpty()) {
            st.push(q.remove());
            i++;
        }

        while(!st.isEmpty()) {
            q.add(st.pop());
        }

        i = size - k;
        while(i > 0) {
            q.add(q.remove());
            i--;
        }
        return q;
    }
}
