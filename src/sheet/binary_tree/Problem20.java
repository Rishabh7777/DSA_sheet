package sheet.binary_tree;

import java.util.HashMap;

//build tree with in-order and pre-order traversals
public class Problem20 {
    private static HashMap<Integer, Integer> inOrderMap;
    private static int iter;

    private static Node helper(int[] preOrder, int l, int r) {
        if(l > r) {
            return null;
        }
        int val = preOrder[iter++];
        Node root = new Node(val);
        int idx = inOrderMap.get(val);
        root.left = helper(preOrder, l, idx-1);
        root.right = helper(preOrder, idx+1, r);
        return root;
    }

    public static Node buildTree(int[] inorder, int[] preorder, int n) {
        inOrderMap = new HashMap<>();
        iter = 0;
        for(int i=0; i<inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }
}
