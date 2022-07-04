package sheet.binary_tree;

import java.util.Stack;

//pre-order traversal
public class Problem7 {
    public static void preOrderRecursive(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void preOrderIterative(Node root) {
        if(root == null) {
            System.out.println("No tree");
            return;
        }
        Node curr = root;
        Stack<Node> st = new Stack<>();
        st.push(curr);
        while(!st.isEmpty()) {
            curr = st.pop();
            System.out.print(curr.data + " ");
            if(curr.right != null) {
                st.push(curr.right);
            }
            if(curr.left != null) {
                st.push(curr.left);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right = new Node(6);

        preOrderRecursive(root);
        System.out.println();
        preOrderIterative(root);
    }
}
