package sheet.binary_tree;

import java.util.Stack;

//inorder traversal of tree
public class Problem6 {
    public static void inOrderRecursive(Node node) {
        if(node == null) {
            return;
        }
        inOrderRecursive(node.left);
        System.out.print(node.data + " ");
        inOrderRecursive(node.right);
    }

    public static void inOrderIterative(Node node) {
        Stack<Node> st = new Stack<>();
        while(!st.isEmpty() || node != null) {
            if(node != null) {
                st.push(node);
                node = node.left;
            } else {
                node = st.peek();
                System.out.print(st.pop().data + " ");
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(16);
        root.right = new Node(22);
        root.left.left = new Node(11);
        root.left.right = new Node(17);
        inOrderRecursive(root);
        System.out.println();
        inOrderIterative(root);
    }
}
