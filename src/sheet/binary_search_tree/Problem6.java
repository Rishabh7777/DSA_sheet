package sheet.binary_search_tree;

import java.util.Stack;

public class Problem6 {
    static class Node {
        int data;
        Node left, right,next;
        public Node(int data){
            this.data = data;
        }
    }

    private Node succ = null;

    public void populateNext(Node root) {
        Stack<Node> st = new Stack<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.right;
            } else {
                curr = st.pop();
                curr.next = succ;
                succ = curr;
                curr = curr.left;
            }
        }
    }
}
