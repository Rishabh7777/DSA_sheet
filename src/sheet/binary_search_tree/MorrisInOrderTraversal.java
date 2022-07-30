package sheet.binary_search_tree;

public class MorrisInOrderTraversal {
    public static void sol(Node root) {
        Node current, pre;
        //if tree does not exist
        if (root == null) {
            return;
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                pre = current.left;
                //get the rightmost node of left subtree before the current
                //or in-order predecessor of current
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                //make current as the right node of pre
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    //revert the changes made to the tree
                    //i.e. fix the right child of predecessor back to null
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    } //O(n)
}
