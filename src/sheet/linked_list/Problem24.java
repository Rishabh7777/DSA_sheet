package sheet.linked_list;

import static sheet.linked_list.NodeDoubly.*;

//rotate a DLL anti-clockwise by N nodes
public class Problem24 {
    //make the DLL circular, then find the new head, and then make the DLL as straight again
    public static NodeDoubly rotate(NodeDoubly head, int n) {
        if(head == null || head.next == null) {
            return null;
        }
        //find tail of the DLL
        NodeDoubly tail, curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        tail = curr;
        //make the DLL circular
        tail.next = head;
        head.prev = tail;
        //find the new head by moving by n nodes
        while(n > 0) {
            tail = head;
            head = head.next;
            n--;
        }
        //make the DLL straight again
        tail.next = null;
        head.prev = null;
        //return new head
        return head;
    }

    public static void main(String[] args) {
        NodeDoubly head;
        head = insert(null, 9);
        head = insert(head, 8);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 2);
        head = insert(head, 1);

        printDLL(head);
        head = rotate(head, 3);
        printDLL(head);
    }
}
