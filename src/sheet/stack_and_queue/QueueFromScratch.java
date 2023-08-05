package sheet.stack_and_queue;

public class QueueFromScratch {
    int front, rear;
    int[] arr = new int[100005];

    QueueFromScratch() {
        front=0;
        rear=0;
    }

    void push(int x) {
        arr[rear++] = x;
    }

    int pop() {
        if(front >= rear) {
            return -1;
        }
        return arr[front++];
    }
}
