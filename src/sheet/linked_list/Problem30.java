package sheet.linked_list;

public class Problem30 {
    static class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;
        }
    }

    //Function to clone a linked list with next and random pointer.
    public static Node copyList(Node head) {
        if(head == null) {
            return null;
        }

        Node resHead = new Node(head.data);

        // clone normal list with next pointers
        Node original = head;
        Node clone = resHead;
        while(original.next != null) {
            // make next node for cloned list
            clone.next = new Node(original.next.data);
            original = original.next;
            clone = clone.next;
        }

        original = head;
        clone = resHead;
        while(original != null) {
            // change next of original and clone nodes
            // so the original and clone lists are now connected
            Node temp = original.next;
            original.next = clone;
            original = temp;
            temp = clone.next;
            clone.next = original;
            clone = temp;
        }

        // add random pointers to cloned list
        original = head;
        clone = resHead;
        while(clone.next != null) {
            if(original.arb != null) {
                original.next.arb = original.arb.next;
            }
            original = clone.next;
            clone = original.next;
        }
        // add random pointer to last node of clone list
        if(original.arb != null) {
            original.next.arb = original.arb.next;
        }

        // remove links between original and clone lists
        original = head;
        clone = resHead;
        while(clone.next != null) {
            original.next = clone.next;
            original = original.next;
            clone.next = original.next;
            clone = clone.next;
        }
        original.next = null;

        return resHead;
    }
}
