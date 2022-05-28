package sheet.linked_list;

import static sheet.linked_list.Problem1.printLL;

public class Problem13 {
    private static Node getMiddleNode(Node head) {
        if(head == null) {
            return null;
        }
        Node slow = head, fast = head;
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static Node merge(Node left, Node right) {
        //create a dummy node
        Node merged = new Node(-1);
        Node temp = merged;
        while (left != null && right != null) {
            if (left.getData() < right.getData()) {
                temp.setNext(left);
                left = left.getNext();
            } else {
                temp.setNext(right);
                right = right.getNext();
            }
            temp = temp.getNext();
        }
        // process the unfinished nodes
        while (left != null) {
            temp.setNext(left);
            left = left.getNext();
            temp = temp.getNext();
        }
        while (right != null) {
            temp.setNext(right);
            right = right.getNext();
            temp = temp.getNext();
        }
        //returning after node -1 (first node)
        return merged.getNext();
    }

    public static Node mergeSort(Node head) {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node middle = getMiddleNode(head);
        Node nextOfMiddle = middle.getNext();
        //break link between two halves of LL
        middle.setNext(null);
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        //now merge the two sorted halves
        return merge(left, right);
    }

    public static void main(String[] args) {
        Node head = new Node(15);
        Node node1 = new Node(20);
        Node node2 = new Node(60);
        Node node3 = new Node(10);
        Node node4 = new Node(50);
        Node node5 = new Node(30);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        printLL(head);
        head = mergeSort(head);
        printLL(head);
    }
}