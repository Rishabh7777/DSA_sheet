package sheet.binary_tree;

public class Problem33 {
    private static int res;

    private static int helper(Node root, int k, int node) {
        if(root == null) {
            return 0;
        }
        if(root.data == node) {
            return 1;
        }
        int left = helper(root.left, k, node);
        int right = helper(root.right, k, node);
        if(left == k || right == k) {
            res = root.data;
        }
        if(left == 0 && right == 0) {
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public int kthAncestor(Node root, int k, int node) {
        res = -1;
        helper(root, k, node);
        return res;
    }
}
