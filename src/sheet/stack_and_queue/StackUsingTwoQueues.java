package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    void push(int a) {
        q1.add(a);
    }

    int pop() {
        if(q1.size() == 0) {
            return -1;
        }
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        int res = q1.remove();
        while(q2.size() > 0) {
            q1.add(q2.remove());
        }
        return res;
    }
}
