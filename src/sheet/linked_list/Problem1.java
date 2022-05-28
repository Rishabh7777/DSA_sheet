package sheet.linked_list;

public class Problem1 {
    public static Node rev(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    } //O(n)

    public static Node revRecur(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node rest = revRecur(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return rest;
    } //O(n)

    public static void printLL(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.getData() + " -> ");
            curr = curr.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        head.setNext(two);
        two.setNext(three);
        three.setNext(four);
        printLL(head);
        head = revRecur(head);
        printLL(head);
        head = rev(head);
        printLL(head);
    }
}