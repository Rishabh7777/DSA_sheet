package sheet.binary_tree;

public class Problem28 {
    private static int maxSum;

    public static int maxSumSubTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = maxSumSubTree(root.left);
        int rightSum = maxSumSubTree(root.right);
        int currSum = leftSum + root.data + rightSum;
        if(currSum > maxSum) {
            maxSum = currSum;
        }
        return currSum;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);
        maxSum = 0;
        maxSumSubTree(root);
        System.out.println(maxSum);
    }
}
