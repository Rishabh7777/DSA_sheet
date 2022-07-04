package sheet.binary_tree;

//find height of BT
public class Problem3 {
    public static int getHeight(Node node) {
        if(node == null) {
            return 0;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
