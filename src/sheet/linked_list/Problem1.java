package sheet.linked_list;

public class Problem1 {
    public static Node rev(Node head) {
        Node prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    } //O(n)

    public static Node revRecur(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node rest = revRecur(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    } //O(n)

    public static void printLL(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = null;
        head = Node.insert(head, 4);
        head = Node.insert(head, 3);
        head = Node.insert(head, 2);
        head = Node.insert(head, 1);
        printLL(head);
        head = revRecur(head);
        printLL(head);
        head = rev(head);
        printLL(head);
    }
}