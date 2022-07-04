package sheet.binary_tree;

public class Problem26 {
    private int maxSum, maxCount;

    private void helper(Node root, int currSum, int count) {
        if(root == null) {
            if(count > maxCount) {
                maxSum = currSum;
                maxCount = count;
            } else if(count == maxCount && currSum > maxSum) {
                maxSum = currSum;
            }
            return;
        }
        helper(root.left, currSum + root.data, count + 1);
        helper(root.right, currSum + root.data, count + 1);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        maxSum = 0;
        maxCount = 0;
        helper(root, 0, 0);
        return maxSum;
    }
}
