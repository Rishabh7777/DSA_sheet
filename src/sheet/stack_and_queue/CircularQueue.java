package sheet.stack_and_queue;

public class CircularQueue {
    int[] arr;
    int front, rear, size;

    CircularQueue(int queueSize) {
        arr = new int[queueSize];
        front = rear = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return (front == -1);
    }

    public boolean isFull() {
        if(rear + 1 == front) {
            return true;
        }
        return rear == arr.length && front == 0;
    }

    public void enqueue(int data) {
        // check if queue is full
        if(isFull()) {
            System.out.println("Queue is full.");
            return;
        }
        if(rear == arr.length-1) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = data;
        size++;
        if(front == -1) {
            front = 0;
        }
    }

    public void dequeue() {
        if(isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Dequeued: " + arr[front]);
        arr[front] = -1;
        if(front == rear) {
            front = rear = -1;
            size--;
            return;
        }
        if(front == arr.length-1) {
            front = 0;
        } else {
            front++;
        }
        size--;
    }

    public void getSize() {
        System.out.println("Size: " + this.size);
    }

    public void display() {
        int temp = front;
        while(temp != rear) {
            System.out.print(arr[temp++] + " ");
            if(temp == arr.length) {
                temp = 0;
            }
        }
        System.out.println(arr[temp]);
    }

    public static void main(String[] args) {
        CircularQueue obj = new CircularQueue(4);
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        obj.display();
        System.out.println("=============================================");
        obj.dequeue();
        obj.dequeue();
        System.out.println("=============================================");
        obj.display();
        System.out.println("=============================================");
        obj.enqueue(10);
        obj.enqueue(20);
        obj.display();
        System.out.println("=============================================");
        obj.dequeue();
        obj.display();
    }
}
