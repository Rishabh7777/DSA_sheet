package sheet.binary_tree;

import java.util.Stack;

//post-order traversal
public class Problem8 {
    public static void postOrderRecursive(Node root) {
        if(root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public static void postOrderIterative(Node root) {
        if(root == null) {
            System.out.println("No tree");
            return;
        }
        Stack<Node> st = new Stack<>();
        Stack<Integer> res = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            Node curr = st.pop();
            res.push(curr.data);
            if(curr.left != null) {
                st.push(curr.left);
            }
            if(curr.right != null) {
                st.push(curr.right);
            }
        }
        while(!res.isEmpty()) {
            System.out.print(res.pop() + " ");
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

        postOrderRecursive(root);
        System.out.println();
        postOrderIterative(root);
    }
}
