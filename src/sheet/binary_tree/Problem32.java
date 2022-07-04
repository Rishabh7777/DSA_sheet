package sheet.binary_tree;

public class Problem32 {
    private static Node lca(Node root, int n1, int n2) {
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

    private static int getDist(Node root, int key) {
        //-ve base case
        if(root == null) {
            return 0;
        }
        //when key found
        if(root.data == key) {
            return 1;
        }
        int left = getDist(root.left, key);
        int right = getDist(root.right, key);
        if(left == 0 && right == 0) {
            //if key is not found in current sub-tree
            return 0;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public static int findDist(Node root, int a, int b) {
        //get common ancestor of a and b
        Node ret = lca(root, a, b);
        //find distance of a from ret node
        int leftD = getDist(ret, a);
        //find distance of b from ret node
        int rightD = getDist(ret, b);
        return (leftD + rightD - 2);
    }
}
