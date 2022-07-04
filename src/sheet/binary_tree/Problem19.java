package sheet.binary_tree;

public class Problem19 {
    private static int helper(Node root) {
        if(root.left == null && root.right == null) {
            int temp = root.data;
            root.data = 0;
            return temp;
        }
        int leftSum = 0, rightSum = 0;
        if(root.left != null) {
            leftSum = helper(root.left);
        }
        if(root.right != null) {
            rightSum = helper(root.right);
        }
        int temp = root.data;
        root.data = leftSum + rightSum;
        return (temp + root.data);
    }

    public static void toSumTree(Node root) {
        if(root == null) {
            return;
        }
        helper(root);
    }
}
