package sheet.linked_list;

//remove loop from LL
public class DeleteLoop {
    public static void removeLoop(Node head) {
        if(head == null) {
            return;
        }
        Node slow = head, fast = head.next;
        //check if LL contains a loop or not
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //both pointers now pointing to the same node
        //find the size of the loop
        int size = 1;
        fast = fast.next;
        while(fast != slow) {
            fast = fast.next;
            size++;
        }
        //update pointers to the head
        slow = head;
        fast = head;
        //move pointer fast by (size) nodes
        for(int i=0; i<size-1; i++) {
            fast = fast.next;
        }
        //now keep moving both pointers until they point to first and last node of the loop
        while(fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        //change next pointer of fast node to null
        fast.next = null;
    }
}
