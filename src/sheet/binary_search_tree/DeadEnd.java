package sheet.binary_search_tree;

public class DeadEnd {
    private static boolean helper(Node root, int low, int high) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return low == high;
        }
        return (helper(root.left, low, root.data-1) || helper(root.right, root.data+1, high));
    }

    public static boolean isDeadEnd(Node root) {
        return helper(root, 1, Integer.MAX_VALUE);
    }
}
