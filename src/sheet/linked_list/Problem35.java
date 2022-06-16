package sheet.linked_list;

import static sheet.linked_list.Problem1.rev;

public class Problem35 {
    public static int getNthFromLast(Node head, int n) {
        head = rev(head);
        Node curr = head;
        while(curr != null) {
            if(n == 1) {
                return curr.data;
            }
            n--;
            curr = curr.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        Node head = null;
        head = Node.insert(head, 9);
        head = Node.insert(head, 8);
        head = Node.insert(head, 7);
        head = Node.insert(head, 6);
        int n = 2;
        System.out.println(getNthFromLast(head, n));
    }
}
