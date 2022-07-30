package sheet.binary_search_tree;

public class Problem7 {
    public static Node LCA(Node root, int n1, int n2) {
        if(root.data == n1 || root.data == n2) {
            return root;
        }
        //if n1 and n2 lies on left and right sub-trees
        if((root.data > n1 && root.data < n2) || (root.data < n1 && root.data > n2)) {
            return root;
        }
        //if n1 and n2 lies on right or left sub-tree
        if(root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        } else {
            return LCA(root.left, n1, n2);
        }
    }
}
