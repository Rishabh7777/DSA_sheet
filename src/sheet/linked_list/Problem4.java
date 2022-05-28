package sheet.linked_list;

//remove loop from LL
public class Problem4 {
    public static void removeLoop(Node head) {
        if(head == null) {
            return;
        }
        Node slow = head, fast = head.getNext();
        //check if LL contains a loop or not
        while(slow != fast) {
            if(fast == null || fast.getNext() == null) {
                return;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //both pointers now pointing to the same node
        //find the size of the loop
        int size = 1;
        fast = fast.getNext();
        while(fast != slow) {
            fast = fast.getNext();
            size++;
        }
        //update pointers to the head
        slow = head;
        fast = head;
        //move pointer fast by (size-1) nodes
        for(int i=0; i<size-1; i++) {
            fast = fast.getNext();
        }
        //now keep moving both pointers until they point to first and last node of the loop
        while(fast.getNext() != slow) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        //change next pointer of fast node to null
        fast.setNext(null);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node2);

        removeLoop(head);
        Problem1.printLL(head);
    }
}
