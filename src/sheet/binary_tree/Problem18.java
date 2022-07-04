package sheet.binary_tree;

public class Problem18 {
    private static Node prev, head;

    private static void helper(Node root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        if(prev == null) {
            //the leftmost node will be head if DLL
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        helper(root.right);
    }

    public static Node binaryTreeToDLL(Node root) {
        prev = null;
        head = null;
        helper(root);
        return head;
    }
}
