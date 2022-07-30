package sheet.binary_search_tree;

import java.util.ArrayList;
import java.util.Stack;

public class KthLargestElement {
    public int kthLargest(Node root, int K) {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        //get in-order traversal of tree
        while(!st.isEmpty() || root != null) {
            if(root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                list.add(root.data);
                root = root.right;
            }
        }
        //get the kth element from list
        int idx = list.size() - K;
        for(int i=0; i<list.size(); i++) {
            if(i == idx) {
                return list.get(i);
            }
        }
        return -1;
    }
}
