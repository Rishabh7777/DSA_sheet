package sheet.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//reverse level order traversal
public class Problem2 {
    public static ArrayList<Integer> reverseLevelOrder(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node front = q.poll();
            st.push(front);
            if(front.right != null) {
                q.add(front.right);
            }
            if(front.left != null) {
                q.add(front.left);
            }
        }
        while(!st.isEmpty()) {
            list.add(st.pop().data);
        }
        return list;
    }
}
