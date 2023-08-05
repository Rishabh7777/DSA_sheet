package sheet.stack_and_queue;

public class StackAndQueueUsingDequeue {
    private static class Node {
        int value;
        Node prev, next;

        Node(int value) {
            this.value = value;
            prev = next = null;
        }
    }

    private static class Dequeue {
        Node head, tail;
        int size;

        Dequeue() {
            head = tail = null;
            size = 0;
        }

        public void insertFirst(int data) {
            if(head == null) {
                head = tail = new Node(data);
                size++;
                return;
            }
            // make a new node to be inserted at first place
            // have to change some pointers and head pointing
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }

        public void insertLast(int data) {
            if(head == null) {
                head = tail = new Node(data);
                size++;
                return;
            }
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }

        public int removeFirst() {
            if(head == null) {
                return -1;
            }
            if(head.next == null) {
                int data = head.value;
                head = tail = null;
                size--;
                return data;
            }
            int data = head.value;
            // remove connections between head and its next node
            Node newHead = head.next;
            head.next = null;
            newHead.prev = null;
            head = newHead;
            size--;
            return data;
        }

        public int removeLast() {
            if(head == null) {
                return -1;
            }
            if(head.next == null) {
                int data = head.value;
                head = tail = null;
                size--;
                return data;
            }
            int data = tail.value;
            // remove connections between tail and its previous node
            Node newTail = tail.prev;
            tail.prev = null;
            newTail.next = null;
            tail = newTail;
            size--;
            return data;
        }

        public int peek() {
            if(head == null) {
                return -1;
            }
            return head.value;
        }
    }

    public static class Queue {
        Dequeue dq = new Dequeue();

        public void insert(int data) {
            dq.insertLast(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.peek();
        }

        public int size() {
            return dq.size;
        }
    }

    public static class Stack {
        Dequeue dq = new Dequeue();

        public void insert(int data) {
            dq.insertFirst(data);
        }

        public int remove() {
            return dq.removeFirst();
        }

        public int peek() {
            return dq.peek();
        }

        public int size() {
            return dq.size;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(2);
        q.insert(3);
        q.remove();
        q.insert(6);
        System.out.println("Peeked: " + q.peek());
        System.out.println("Size: " + q.size());

        Stack st = new Stack();
        st.insert(2);
        st.insert(3);
        st.remove();
        st.insert(6);
        System.out.println("Peeked: " + st.peek());
        System.out.println("Size: " + st.size());
    }
}
