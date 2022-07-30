package sheet.binary_search_tree;

public class LargestBST {
    private static class NodeInfo {
        int size; //size of largest BST at particular node
        int min; //minimum node until current root
        int max; //maximum node until current node
        boolean isBST; //true -> tree is BST from bottom until current root

        public NodeInfo() {}

        public NodeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    private static NodeInfo helper(Node root) {
        //base case
        if(root == null) {
            return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        //using post-order traversal to get info about left and right subtrees
        NodeInfo left = helper(root.left);
        NodeInfo right = helper(root.right);
        //fill node info for root
        NodeInfo curr = new NodeInfo();
        curr.min = Math.min(Math.min(left.min, right.min), root.data);
        curr.max = Math.max(Math.max(left.max, right.max), root.data);
        //check if tree is BST including current root
        curr.isBST = (left.isBST && right.isBST) && (left.max < root.data && root.data < right.min);
        //update size of max BST upto current root
        if(curr.isBST) {
            curr.size = left.size + right.size + 1;
        } else {
            curr.size = Math.max(left.size, right.size);
        }
        return curr;
    }

    public static int largestBst(Node root) {
        return helper(root).size;
    }
}
