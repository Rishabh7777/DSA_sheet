package sheet.stack_and_queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    void Push(int x) {
        s1.push(x);
    }

    int Pop() {
        if(s1.isEmpty()) {
            return -1;
        }
        while(s1.size() > 1) {
            s2.push(s1.pop());
        }
        int data = s1.pop();
        while(s2.size() != 0) {
            s1.push(s2.pop());
        }
        return data;
    }
}
