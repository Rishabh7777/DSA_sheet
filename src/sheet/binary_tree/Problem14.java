package sheet.binary_tree;

public class Problem14 {
    //find heights of left and right sub-tree and check is diff is greater than 1 or not
    private static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if(left == -1 || right == -1) {
            return -1;
        }
        if(Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(Node root) {
        int ret = getHeight(root);
        return (ret != -1);
    }
}
