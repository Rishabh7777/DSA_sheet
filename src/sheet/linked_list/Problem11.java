package sheet.linked_list;

import static sheet.linked_list.Problem1.rev;

public class Problem11 {
    public static Node findIntersection(Node head1, Node head2) {
        Node node = null;
        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                Node newNode = new Node(head1.data);
                newNode.next = node;
                node = newNode;
                head1 = head1.next;
                head2 = head2.next;
            } else if(head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }
        return rev(node);
    }
}
