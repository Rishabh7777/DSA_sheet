package sheet.linked_list;

public class Problem2 {
    public static Node revInGroups(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node prev = null, curr = head, next;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }
        head.setNext(revInGroups(curr, k));
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        int k = 4;

        Problem1.printLL(head);
        head = revInGroups(head, k);
        Problem1.printLL(head);
    }
}
