package sheet.binary_search_tree;

import java.util.ArrayList;
import java.util.Collections;

public class Problem9_10 {
    private ArrayList<Integer> list;

    private void getInOrder(Node root) {
        if(root == null) {
            return;
        }
        getInOrder(root.left);
        list.add(root.data);
        getInOrder(root.right);
    }

    private Node constructBST(ArrayList<Integer> inOrder, int low, int high) {
        if(low > high) {
            return null;
        }
        int idx = (low + high + 1) / 2;
        Node root = new Node(inOrder.get(idx));
        root.left = constructBST(inOrder, low, idx-1);
        root.right = constructBST(inOrder, idx+1, high);
        return root;
    } //O(n)

    public Node binaryTreeToBST(Node root) {
        if(root == null) {
            return null;
        }
        //get the in-order traversal of BT
        list = new ArrayList<>();
        getInOrder(root);
        //sort the list to get in-order of BST
        Collections.sort(list);
        //construct BST as per list
        return constructBST(list, 0, list.size()-1);
    } //O(n)
}
