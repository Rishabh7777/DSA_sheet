package sheet.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem10 {
    public static ArrayList<Integer> rightView(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node front = q.poll();
                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
                if(i == size-1) {
                    list.add(front.data);
                }
            }
        }
        return list;
    }
}
