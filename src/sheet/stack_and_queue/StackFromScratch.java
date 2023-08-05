package sheet.stack_and_queue;

public class StackFromScratch {
    int max, top;
    int[] arr;

    StackFromScratch(int max) {
        this.max = max;
        top = -1;
        arr = new int[max];
    }

    private void push(int data) {
        if(top == (max - 1)) {
            System.out.println("The stack is full.");
            return;
        }
        arr[++top] = data;
    }

    private void pop() {
        if(top < 0) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.println("Removed " + arr[top] + " from stack.");
        arr[top--] = 0;
    }

    private void peek() {
        if(top < 0) {
            System.out.println("The stack is empty.");
            return;
        }
        System.out.println("The top of stack is: " + arr[top]);
    }

    private void printStack() {
        if(top < 0) {
            System.out.print("Nothing in the stack.");
        }
        int i = top;
        while(i >= 0) {
            System.out.print(arr[i--]);
            if(i >= 0) {
                System.out.print(" <-- ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackFromScratch myStack = new StackFromScratch(10);
        myStack.printStack();
        myStack.push(2);
        myStack.push(7);
        myStack.push(12);
        myStack.peek();
        myStack.push(23);
        myStack.printStack();
        myStack.pop();
        myStack.push(56);
        myStack.printStack();
        myStack.pop();
        myStack.pop();
        myStack.printStack();
    }
}
