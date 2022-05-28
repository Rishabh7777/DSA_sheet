package sheet.linked_list;

public class Problem6 {
    //remove duplicate values from sorted LL
    public static void removeDuplicates(Node head) {
        Node curr = head;
        while(curr.getNext() != null) {
            if(curr.getData() == curr.getNext().getData()) {
                Node temp = curr.getNext();
                curr.setNext(curr.getNext().getNext());
                temp.setNext(null);
                continue;
            }
            curr = curr.getNext();
        }
    } //O(n)

    public static void main(String[] args) {
        Node head = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        Problem1.printLL(head);
        removeDuplicates(head);
        Problem1.printLL(head);
    }
}
