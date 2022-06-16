package sheet.linked_list;

import static sheet.linked_list.NodeDoubly.*;

//given a DLL, reverse it by changing the next and prev pointers
public class Problem20 {
    public static NodeDoubly reverseDLL(NodeDoubly head) {
        NodeDoubly previous = null, curr = head;
        while(curr != null) {
            NodeDoubly temp = curr.next;
            curr.next = previous;
            curr.prev = temp;
            previous = curr;
            curr = temp;
        }
        return previous;
    }

    public static void main(String[] args) {
        NodeDoubly head = null;
        head = insert(head, 7);
        head = insert(head, 5);
        head = insert(head, 3);

        printDLL(head);
        head = reverseDLL(head);
        printDLL(head);
    }
}
