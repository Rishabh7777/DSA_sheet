package sheet.linked_list;

//move last node of LL to first position, i.e. rotate LL clockwise by 1
public class Problem8 {
    public static Node rotate(Node head) {
        Node curr = head;
        while(curr.getNext().getNext() != null) {
            curr = curr.getNext();
        }
        curr.getNext().setNext(head);
        head = curr.getNext();
        curr.setNext(null);
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Problem1.printLL(head);
        head = rotate(head);
        Problem1.printLL(head);
    }
}
