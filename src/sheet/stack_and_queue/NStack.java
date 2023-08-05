package sheet.stack_and_queue;

import java.util.Arrays;

public class NStack {
    int[] arr, next, top;
    int freeSpace, stackCount;

    NStack(int size, int stackCount) {
        // arr is the stack holding all the elements
        this.arr = new int[size];
        // next is giving next free space after next[i] if arr[i] is empty
        // else giving following element in the current stack after arr[i]
        this.next = new int[size];
        for(int i=0; i<size-1; i++) {
            next[i] = i+1;
        }
        next[size-1] = -1;
        // stackCount is giving the number of stacks in the arr
        this.stackCount = stackCount;
        // top is giving the topmost element of each stack
        this.top = new int[stackCount];
        Arrays.fill(top, -1);
        // freeSpace is giving the free place in arr where new element can be inserted
        this.freeSpace = 0;
    }

    public void push(int data, int stackNum) {
        if(freeSpace == -1) {
            System.out.println("Stack is full.");
            return;
        }
        // store the data at freeSpace, this new data will become top of the stackNum now so update top,
        // update next to store following element of stackNum now in place of storing next freeSpace,
        // then finally update freeSpace with new value taken from next not just incrementing
        arr[freeSpace] = data;
        int temp = next[freeSpace];
        next[freeSpace] = top[stackNum - 1];
        top[stackNum - 1] = freeSpace;
        freeSpace = temp;
    }

    public void getTop(int stackNum) {
        if(top[stackNum - 1] == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Top of stack " + stackNum + ": " + arr[top[stackNum - 1]]);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(next));
    }

    public void pop(int stackNum) {
        if(top[stackNum - 1] == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        // do the reverse of pushing data into stacks
        int index = top[stackNum - 1];
        System.out.println("Popped " + arr[index] + " from stack " + stackNum);
        arr[top[stackNum - 1]] = -1;
        top[stackNum - 1] = next[index];
        next[index] = freeSpace;
        freeSpace = index;
    }

    public static void main(String[] args) {
        NStack obj = new NStack(10, 3);

        obj.push(15, 3);
        obj.push(45, 3);
        obj.push(17, 2);
        obj.push(49, 2);
        obj.push(39, 2);
        obj.push(11, 1);
        obj.push(9, 1);
        obj.push(7, 1);
        obj.push(93, 2);
        obj.push(88, 1);
        obj.push(74, 3);

        System.out.println("======================================");

        obj.getTop(1);
        obj.getTop(2);
        obj.getTop(3);

        System.out.println("======================================");

        obj.pop(1);
        obj.pop(1);
        obj.pop(1);
        obj.pop(1);
        obj.pop(3);

        System.out.println("======================================");

        obj.push(33, 2);
        obj.push(42, 1);
        obj.push(3, 2);
        obj.push(10, 3);

        obj.getTop(1);
        obj.getTop(2);
        obj.getTop(3);
    }
}
