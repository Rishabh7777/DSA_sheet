package sheet.binary_tree;

public class Problem4 {
    private static int maxDiameter = Integer.MIN_VALUE;

    private static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSubHeight = heightOfTree(root.left);
        int rightSubHeight = heightOfTree(root.right);
        int currDiameter = leftSubHeight + rightSubHeight + 1;
        if(currDiameter > maxDiameter) {
            maxDiameter = currDiameter;
        }
        return Math.max(leftSubHeight, rightSubHeight) + 1;
    }

    public static int diameter(Node root) {
        heightOfTree(root);
        return maxDiameter;
    }
}
