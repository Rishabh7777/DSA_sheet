package sheet.linked_list;

import static sheet.linked_list.NodeDoubly.insert;
import static sheet.linked_list.NodeDoubly.printDLL;

public class Problem25 {
    public static NodeDoubly revDLLInGroups(NodeDoubly head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        NodeDoubly prevNode = null, curr = head, nextNode;
        int count = 0;
        while(count < k && curr != null) {
            nextNode = curr.next;
            curr.next = prevNode;
            if(prevNode != null) {
                prevNode.prev = curr;
            }
            prevNode = curr;
            curr = nextNode;
            count++;
        }
        NodeDoubly retNode = revDLLInGroups(curr, k);
        head.next = retNode;
        if(retNode != null) {
            retNode.prev = head;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        NodeDoubly head;
        head = insert(null, 8);
        head = insert(head, 7);
        head = insert(head, 6);
        head = insert(head, 5);
        head = insert(head, 4);
        head = insert(head, 3);
        head = insert(head, 2);
        head = insert(head, 1);

        printDLL(head);
        head = revDLLInGroups(head, 3);
        printDLL(head);
    }
}
