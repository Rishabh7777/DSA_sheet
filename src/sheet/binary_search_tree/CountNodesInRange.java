package sheet.binary_search_tree;

public class CountNodesInRange {
    private static int count;

    private static void helper(Node root, int l, int h) {
        if(root == null) {
            return;
        }
        helper(root.left, l, h);
        if(root.data >= l && root.data <= h) {
            count++;
        }
        helper(root.right, l, h);
    }

    public static int getCount(Node root,int l, int h) {
        count = 0;
        helper(root, l, h);
        return count;
    }
}
