package sheet.linked_list;

import static sheet.linked_list.Problem1.rev;

public class Problem33 {
    Node compute(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        head = rev(head);
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
        return rev(head);
    }
}
