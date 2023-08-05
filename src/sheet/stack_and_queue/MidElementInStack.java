package sheet.stack_and_queue;

public class MidElementInStack {
    // Have to maintain a mid-pointer from start to access mid-element in O(1).
    // Using a DLL instead of LL to make mid-pointer movement easy while pushing and popping elements.
    static class DLL {
        int data;
        DLL prev, next;

        DLL(int data) {
            this.data = data;
            prev = next = null;
        }
    }

    private final int size;
    private int currSize;
    // For even number of elements, mid will be first of the two mid elements.
    private DLL top, mid;

    MidElementInStack(int size) {
        this.size = size;
        this.currSize = 0;
        top = mid = null;
    }

    // Mid-pointer will move forward for every odd element push in stack.
    public void push(int value) {
        if(currSize == size) {
            System.out.println("Stack is full.");
            return;
        }
        System.out.println("Pushing " + value + " in stack.");
        DLL newNode = new DLL(value);
        if(currSize == 0) {
            top = mid = newNode;
        } else {
            top.next = newNode;
            newNode.prev = top;
            top = newNode;
            if(currSize % 2 == 0) {
                mid = mid.next;
            }
        }
        currSize++;
    } // O(1)

    // Mid-pointer will move backward for every odd pop from the stack.
    public void pop() {
        if(currSize == 0) {
            System.out.println("Stack is empty.");
            return;
        }
        int res = top.data;
        DLL newTop = top.prev;
        top.prev = null;
        if(newTop != null) {
            newTop.next = null;
        }
        top = newTop;
        currSize--;
        if(currSize % 2 == 0) {
            mid = mid.prev;
        }
        System.out.println("Popped " + res + " from the stack.");
    } // O(1)

    public void deleteMid() {
        if(mid == null) {
            System.out.println("Mid not found.");
            return;
        }
        System.out.println("Removing " + mid.data + " from mid.");
        if(mid.prev == null && currSize == 1) {
            top = mid = null;
            currSize--;
        } else if(mid.prev == null) {
            mid.next = null;
            top.prev = null;
            mid = top;
            currSize--;
        } else {
            mid.prev.next = mid.next;
            mid.next.prev = mid.prev;
            DLL newMid = null;
            if(currSize % 2 == 0) {
                newMid = mid.next;
            } else {
                newMid = mid.prev;
            }
            mid.prev = mid.next = null;
            mid = newMid;
            currSize--;
        }
    } // O(1)

    public void getMid() {
        if(this.mid == null) {
            System.out.println("Stack is empty, mid not found.");
            return;
        }
        System.out.println("Mid: " + mid.data);
    } // O(1)

    public void getTop() {
        if(this.mid == null) {
            System.out.println("Stack is empty, top not found.");
            return;
        }
        System.out.println("Top: " + top.data);
    } // O(1)

    public static void main(String[] args) {
        MidElementInStack obj = new MidElementInStack(20);
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
        obj.push(55);
        obj.push(66);
        obj.push(77);
        obj.push(88);
        obj.push(99);

        obj.pop();
        obj.pop();

        obj.getMid();
        obj.deleteMid();
        obj.getMid();

        /*obj.push(2);
        obj.getMid();
        obj.push(6);
        obj.getMid();
        obj.push(9);
        obj.getMid();
        obj.getTop();
        obj.push(3);
        obj.getMid();
        obj.push(5);
        obj.getMid();
        obj.push(10);
        obj.getMid();
        obj.getTop();*/

        /*System.out.println("=================================================");
        obj.deleteMid();
        obj.getMid();
        obj.getTop();

        System.out.println("=================================================");
        obj.deleteMid();
        obj.getMid();
        obj.getTop();

        System.out.println("=================================================");
        obj.deleteMid();
        obj.getMid();
        obj.getTop();

        System.out.println("=================================================");
        obj.deleteMid();
        obj.getMid();
        obj.getTop();

        System.out.println("=================================================");
        obj.deleteMid();
        obj.getMid();
        obj.getTop();*/

        /*obj.pop();
        obj.getMid();
        obj.getTop();
        obj.pop();
        obj.getMid();
        obj.pop();
        obj.getMid();
        obj.getTop();
        obj.pop();
        obj.getMid();
        obj.pop();
        obj.getMid();
        obj.pop();*/
    }
}
