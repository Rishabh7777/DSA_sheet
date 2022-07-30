package sheet.binary_search_tree;

import static sheet.binary_search_tree.BST.*;

public class FlattenBST {
    private static Node prev;

    private static void helper(Node root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        prev.left = null;
        prev.right = root;
        prev = root;
        helper(root.right);
    }

    public static Node sol(Node root) {
        prev = new Node(-1);
        Node temp = prev;
        helper(root);
        return temp.right;
    }

    public static void main(String[] args) {
        Node root = insert(null, 78);
        root = insert(root, 69);
        root = insert(root, 4);
        root = insert(root, 72);
        root = insert(root, 80);
        root = insert(root, 79);

        root = sol(root);
        while(root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }
}
