package sheet.binary_tree;

public class Problem22 {
    private static int helper(Node root) {
        //base case
        if(root == null) {
            return 0;
        }
        //get sum of left and right sub-trees
        int left = helper(root.left);
        int right = helper(root.right);
        //if found a sub-tree which is not a sum tree
        if(left == -1 || right == -1) {
            return -1;
        }
        if(left == 0 && right == 0) {
            return root.data;
        }
        if(left == 0) {
            return (root.data == right) ? (root.data + right) : -1;
        }
        if(right == 0) {
            return (root.data == left) ? (root.data + left) : -1;
        }
        return (root.data == left + right) ? (root.data + left + right) : -1;
    }

    boolean isSumTree(Node root) {
        if(root == null) {
            return true;
        }
        int ret = helper(root);
        return ret != -1;
    }
}
