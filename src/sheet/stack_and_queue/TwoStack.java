package sheet.stack_and_queue;

public class TwoStack {
	int size;
	int top1,top2;
	int[] arr = new int[100];

	TwoStack() {
		size = 100;
		top1 = -1;
		top2 = size;
	}
}

class Test {
    void push1(int x, TwoStack sq) {
        if(sq.top1 == (sq.top2 - 1)) {
            System.out.println("Stack is full");
            return;
        }
        sq.arr[++sq.top1] = x;
    }

    void push2(int x, TwoStack sq) {
        if(sq.top1 == (sq.top2 - 1)) {
            System.out.println("Stack is full");
            return;
        }
        sq.arr[--sq.top2] = x;
    }

    int pop1(TwoStack sq) {
        if(sq.top1 == -1) {
            return -1;
        }
        return sq.arr[sq.top1--];
    }

    int pop2(TwoStack sq) {
        if(sq.top2 == sq.size) {
            return -1;
        }
        return sq.arr[sq.top2++];
    }
}