package sheet.binary_tree;

public class Problem31 {
    public static Node lca(Node root, int n1, int n2) {
        //-ve base case -> key is not found
        if(root == null) {
            return null;
        }
        //+ve base case -> either n1 or n2 is found
        if(root.data == n1 || root.data == n2) {
            return root;
        }
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if(left != null && right != null) {
            //first common ancestor for n1 and n2 is found
            return root;
        } else if(left != null) {
            return left;
        } else {
            return right;
        }
    }
}
