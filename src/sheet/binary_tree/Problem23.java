package sheet.binary_tree;

public class Problem23 {
    private static int leafLevel;

    private static boolean helper(Node root, int currLevel) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            if(leafLevel == 0) {
                leafLevel = currLevel;
                return true;
            }
            return (currLevel == leafLevel);
        }
        boolean left = helper(root.left, currLevel+1);
        boolean right = helper(root.right, currLevel+1);
        return (left && right);
    }

    public static boolean check(Node root) {
        leafLevel = 0;
        return helper(root, 0);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        System.out.println(check(root));
    }
}
