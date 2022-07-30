package sheet.binary_search_tree;

public class CheckBST {
    private static boolean helper(Node root, int low, int high) {
        if(root == null) {
            return true;
        }
        if(root.data < low || root.data > high) {
            return false;
        }
        boolean left = helper(root.left, low, root.data);
        boolean right = helper(root.right, root.data, high);
        return (left && right);
    }

    public static boolean isBST(Node node) {
        return helper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
