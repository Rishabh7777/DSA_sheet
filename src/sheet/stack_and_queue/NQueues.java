package sheet.stack_and_queue;

import java.util.Arrays;

public class NQueues {
    int[] arr, front, next, rear;
    int freeSpace;

    NQueues(int size, int totalQueues) {
        // to hold all elements of queue
        arr = new int[size];
        // next will hold available freeSpace after next[i] initially(if arr[i] is empty)
        // and will hold next series element for particular queue once element is present at arr[i]
        next = new int[size];
        for(int i=0; i<size-1; i++) {
            next[i] = i+1;
        }
        next[size-1] = -1;
        // front[] - front element of each queue, rear[] - rear element of each queue
        front = new int[totalQueues];
        rear = new int[totalQueues];
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
        // next freeSpace available in arr[]
        freeSpace = 0;
    }

    public void enqueue(int data, int queueNum) {
        if(freeSpace == -1) {
            System.out.println("Queue is full.");
            return;
        } else if(front[queueNum - 1] == -1) {
            front[queueNum - 1] = freeSpace;
        } else {
            next[rear[queueNum - 1]] = freeSpace;
        }
        arr[freeSpace] = data;
        int temp = next[freeSpace];
        next[freeSpace] = -1;
        rear[queueNum - 1] = freeSpace;
        freeSpace = temp;
    }

    public void dequeue(int queueNum) {
        if(front[queueNum - 1] == -1) {
            System.out.println("Queue is empty.");
            return;
        } else {
            int frontIndex = front[queueNum - 1];
            int res = arr[frontIndex];
            System.out.println("Dequeued " + res + " from " + queueNum);
            arr[frontIndex] = -1;
            front[queueNum - 1] = next[frontIndex];
            if(front[queueNum - 1] == -1) {
                rear[queueNum - 1] = -1;
            }
            next[frontIndex] = freeSpace;
            freeSpace = frontIndex;
        }
    }

    public void displayCondition() {
        System.out.println("arr: " + Arrays.toString(arr));
        System.out.println("front: " + Arrays.toString(front));
        System.out.println("rear: " + Arrays.toString(rear));
        System.out.println("next: " + Arrays.toString(next));
    }

    public static void main(String[] args) {
        NQueues obj = new NQueues(6, 3);
        obj.enqueue(15, 1);
        obj.enqueue(21, 1);
        obj.enqueue(43, 3);
        obj.enqueue(5, 2);
        obj.enqueue(72, 3);
        obj.enqueue(33, 3);
        obj.enqueue(100, 1);
        obj.displayCondition();
        System.out.println("==================================================================");
        obj.dequeue(2);
        obj.dequeue(1);
        obj.dequeue(1);
        obj.dequeue(2);
        obj.displayCondition();
        System.out.println("==================================================================");
        obj.enqueue(100, 1);
        obj.enqueue(201, 3);
        obj.enqueue(99, 2);
        obj.enqueue(7, 1);
        obj.displayCondition();
    }
}
