package sheet.linked_list;

public class MergeSort {
    private static Node getMiddleNode(Node head) {
        if(head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        //create a dummy node
        Node merged = new Node(-1);
        Node temp = merged;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        // process the unfinished nodes
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        //returning after node -1 (first node)
        return merged.next;
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddleNode(head);
        Node nextOfMiddle = middle.next;
        //break link between two halves of LL
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        //now merge the two sorted halves
        return merge(left, right);
    }
}