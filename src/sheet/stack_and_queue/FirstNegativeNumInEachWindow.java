package sheet.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumInEachWindow {
    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Queue<Long> q = new LinkedList<>();
        long[] res = new long[N - K + 1];
        int front = 0, rear = K - 1;

        // loop from front to rear and store on A[] all negative numbers in between
        for(int i=0; i<=rear; i++) {
            if(A[i] < 0) {
                q.add(A[i]);
            }
        }

        // a window of size K is from i to j
        // each time the front of queue is the first negative number in that window
        // while moving pointers check if needs to remove or add a negative number in the queue
        while(rear < N) {
            res[front] = q.isEmpty() ? 0 : q.peek();
            if(!q.isEmpty() && q.peek() == A[front]) {
                q.remove();
            }
            front++;
            rear++;
            if(rear < N && A[rear] < 0) {
                q.add(A[rear]);
            }
        }

        return res;
    }
}
