package sheet.binary_search_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static sheet.binary_search_tree.BST.*;

public class MergeTwoBST {
    private static int idx;

    private static int[] inOrderIterative(Node root, int size) {
        Stack<Node> st = new Stack<>();
        int[] inOrder = new int[size];
        idx = size - 1;
        while(!st.isEmpty() || root != null) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                inOrder[idx--] = root.data;
                root = root.right;
            }
        }
        return inOrder;
    } //O(n)

    private static Node constructBST(int[] inOrder, int low, int high) {
        if(low > high) {
            return null;
        }
        int idx = (low + high + 1) / 2;
        Node root = new Node(inOrder[idx]);
        root.left = constructBST(inOrder, low, idx-1);
        root.right = constructBST(inOrder, idx+1, high);
        return root;
    } //O(n)

    public static Node sol(Node root1, int m, Node root2, int n) {
        idx = 0;
        int[] inOrder1 = inOrderIterative(root1, m);
        idx = 0;
        int[] inOrder2 = inOrderIterative(root2, n);
        //now merge the two sorted arrays
        int[] res = new int[m + n];
        int i=0, j=0, idx=0;
        while(i < m && j < n) {
            if(inOrder1[i] < inOrder2[j]) {
                res[idx++] = inOrder1[i++];
            } else {
                res[idx++] = inOrder2[j++];
            }
        }
        while(i < m) {
            res[idx++] = inOrder1[i++];
        }
        while(j < n) {
            res[idx++] = inOrder2[j++];
        }
        return constructBST(res, 0, res.length-1);
    } //O(m + n) as merging two sorted arrays

    public static void main(String[] args) {
        Node root1 = insert(null, 20);
        root1 = insert(root1, 16);
        root1 = insert(root1, 11);
        root1 = insert(root1, 17);
        root1 = insert(root1, 22);

        Node root2 = insert(null, 2);
        root2 = insert(root2, 1);
        root2 = insert(root2, 39);
        root2 = insert(root2, 19);

        Node root = sol(root1, 5, root2, 4);
        printInOrder(root);
    }
}
