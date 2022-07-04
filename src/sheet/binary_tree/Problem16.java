package sheet.binary_tree;

import java.util.ArrayList;
import java.util.Collections;

public class Problem16 {
    private static ArrayList<Integer> list;

    private static void findLeafNodes(Node root) {
        if(root.left == null && root.right == null) {
            list.add(root.data);
            return;
        }
        if(root.left != null) {
            findLeafNodes(root.left);
        }
        if(root.right != null) {
            findLeafNodes(root.right);
        }
    } //O(n)

    public static ArrayList<Integer> boundaryTraversal(Node root) {
        list = new ArrayList<>();
        list.add(root.data);
        if(root.left == null && root.right == null) {
            return list;
        }
        //add all nodes of left boundary to result
        if(root.left != null) {
            Node curr = root.left;
            //keep moving to the leftmost nodes level-by-level
            while(curr.left != null || curr.right != null) {
                list.add(curr.data);
                if(curr.left != null) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
        }
        //add all the leaf nodes to result
        findLeafNodes(root);
        //add all nodes on the right boundary to result
        if(root.right != null) {
            Node curr = root.right;
            ArrayList<Integer> temp = new ArrayList<>();
            while(curr.right != null || curr.left != null) {
                temp.add(curr.data);
                if(curr.right != null) {
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
            Collections.reverse(temp);
            list.addAll(temp);
        }
        return list;
    }
}
