package sheet.linked_list;

public class Problem2 {
    public static Node revInGroups(Node head, int k) {
        if(head == null) {
            return null;
        }
        Node prev = null, curr = head, next;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        head.next = revInGroups(curr, k);
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        head = Node.insert(head, 8);
        head = Node.insert(head, 7);
        head = Node.insert(head, 6);
        head = Node.insert(head, 5);
        head = Node.insert(head, 4);
        head = Node.insert(head, 3);
        head = Node.insert(head, 2);
        head = Node.insert(head, 1);
        int k = 4;

        Problem1.printLL(head);
        head = revInGroups(head, k);
        Problem1.printLL(head);
    }
}
