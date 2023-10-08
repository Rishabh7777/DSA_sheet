package sheet.stack_and_queue;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {
    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();
        // push first half of the queue into stack
        for(int i=0; i<N/2; i++) {
            st.push(q.remove());
        }
        // pop the elements from stack and enqueue them into queue
        while(!st.isEmpty()) {
            q.add(st.pop());
        }
        // dequeue from front of queue and enqueue them into queue
        for(int i=0; i<N/2; i++) {
            q.add(q.remove());
        }
        // push first half of queue into stack
        for(int i=0; i<N/2; i++) {
            st.push(q.remove());
        }
        // add one element from stack and one from front to back of queue
        // in alternate order till stack is empty
        boolean flag = true; // true means add from stack
        while(!st.isEmpty()) {
            if(flag) {
                q.add(st.pop());
            } else {
                q.add(q.remove());
            }
            flag = !flag;
        }
        q.add(q.remove());
        // store result in arraylist in reverse order
        ArrayList<Integer> ar = new ArrayList<>();
        while(!q.isEmpty()) {
            ar.add(q.remove());
        }
        return ar;
    }
}
