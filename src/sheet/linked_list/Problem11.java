package sheet.linked_list;

public class Problem11 {
    public static Node findIntersection(Node head1, Node head2) {
        Node node = null;
        while(head1 != null && head2 != null) {
            if(head1.getData() == head2.getData()) {
                Node newNode = new Node(head1.getData());
                newNode.setNext(node);
                node = newNode;
                head1 = head1.getNext();
                head2 = head2.getNext();
            } else if(head1.getData() < head2.getData()) {
                head1 = head1.getNext();
            } else {
                head2 = head2.getNext();
            }
        }
        return Problem9.reverse(node);
    }
}
