package sheet.linked_list;

public class Problem28 {
    static class Node {
        int data;
        Node next;
        Node bottom;
        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    private static Node merge(Node left, Node right) {
        //create a dummy node
        Node merged = new Node(-1);
        Node temp = merged;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.bottom = left;
                left = left.bottom;
            } else {
                temp.bottom = right;
                right = right.bottom;
            }
            temp = temp.bottom;
        }
        // process the unfinished nodes
        while (left != null) {
            temp.bottom = left;
            left = left.bottom;
            temp = temp.bottom;
        }
        while (right != null) {
            temp.bottom = right;
            right = right.bottom;
            temp = temp.bottom;
        }
        //returning after node -1 (first node)
        return merged.bottom;
    }

    public static Node flatten(Node root) {
        if(root.next == null) {
            return root;
        }
        Node temp = root.next;
        Node retNode = merge(root, temp);
        retNode.next = temp.next;
        return flatten(retNode);
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);
        head.next = new Node(10);
        head.next.bottom = new Node(20);
        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);
        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        head = flatten(head);
        while(head != null) {
            System.out.print(head.data + " -> ");
            head = head.bottom;
        }
    }
}
