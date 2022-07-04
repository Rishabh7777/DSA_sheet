package sheet.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//zig-zag traversal
public class Problem13 {
    //use level-order traversal
    public static ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node front = q.poll();
                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
                temp.add(front.data);
            }
            if(!leftToRight) {
                Collections.reverse(temp);
            }
            list.addAll(temp);
            leftToRight = !leftToRight;
        }
        return list;
    }
}
