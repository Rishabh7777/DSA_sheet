package sheet.binary_tree;

//change tree into its mirror image
public class Problem5 {
    //switch left and right nodes
    public static Node mirrorTree(Node node) {
        if(node == null) {
            return null;
        }
        Node left = mirrorTree(node.left);
        node.left = mirrorTree(node.right);
        node.right = left;
        return node;
    }
}
