package sheet.binary_search_tree;

//construct BST from given pre-order traversal
public class PreOrderToBST {
    public static Node sol(int[] preOrder, int low, int high) {
        //base case
        if(low > high) {
            return null;
        }
        //make a node with preOrder[low]
        Node node = new Node(preOrder[low]);
        //find first value greater than node.data in preOrder
        int idx = low + 1;
        while(idx <= high && preOrder[low] > preOrder[idx]) {
            idx++;
        }
        //call to build left sub-tree
        node.left = sol(preOrder, low+1, idx-1);
        //cal to build right sub-tree
        node.right = sol(preOrder, idx, high);
        return node;
    } //O(n*2)

    private static int idx;

    public static Node sol2(int[] preOrder, int low, int high) {
        //base case
        if(idx >= preOrder.length || preOrder[idx] < low || preOrder[idx] > high) {
            return null;
        }
        //create a new node with preOrder[idx]
        Node node = new Node(preOrder[idx++]);
        //call to build left sub-tree
        node.left = sol2(preOrder, low, node.data-1);
        //call to build right sub-tree
        node.right = sol2(preOrder, node.data+1, high);
        return node;
    } //O(n)

    public static void main(String[] args) {
        int[] preOrder = {10, 5, 1, 7, 40, 50};
        Node root = sol(preOrder, 0, preOrder.length-1);
        BST.printInOrder(root);
        System.out.println();
        idx = 0;
        root = sol2(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        BST.printInOrder(root);
    }
}
