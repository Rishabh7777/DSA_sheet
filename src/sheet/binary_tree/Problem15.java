package sheet.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Problem15 {
    public static void diagonalTraverse(Node root) {
        Queue<Node> q = new LinkedList<>();
        Node curr = root;
        while(!q.isEmpty() || curr != null) {
            if(curr != null) {
                System.out.print(curr.data + " ");
                if(curr.left != null) {
                    q.add(curr.left);
                }
                curr = curr.right;
            } else {
                curr = q.poll();
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalTraverse(root);
    }
}
