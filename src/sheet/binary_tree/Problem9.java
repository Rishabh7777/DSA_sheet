package sheet.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//left view
public class Problem9 {
    //the left view consist of only first node of each level through level-order traversal
    public static ArrayList<Integer> leftView(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            list.add(q.peek().data);
            for(int i=0; i<size; i++) {
                Node front = q.poll();
                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
            }
        }
        return list;
    }
}
