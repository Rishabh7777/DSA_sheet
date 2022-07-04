package sheet.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//level order traversal
public class Problem1 {
    public static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> list = new ArrayList<>(); //to store result
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node front = q.poll();
            list.add(front.data);
            if(front.left != null) {
                q.add(front.left);
            }
            if(front.right != null) {
                q.add(front.right);
            }
        }
        return list;
    }
}
