package sheet.linked_list;

import static sheet.linked_list.Reverse.reverseIterative;

public class Problem33 {
    Node compute(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        head = reverseIterative(head);
        Node max = head, curr = head.next;
        while(curr != null) {
            if(curr.data < max.data) {
                curr = curr.next;
            } else {
                max.next = curr;
                max = curr;
                curr = curr.next;
            }
        }
        max.next = null;
        return reverseIterative(head);
    }
}
