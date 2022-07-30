package sheet.binary_search_tree;

import java.util.Stack;

public class CountPairsInTwoBSTs {
    public static int countPairs(Node root1, Node root2, int x) {
        if(root1 == null || root2 == null) {
            return 0;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        Node top1, top2;
        int count = 0;
        while(true){
            while(root1 != null){
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.right;
            }
            if(st1.isEmpty() || st2.isEmpty()) {
                break;
            }
            top1 = st1.peek();
            top2 = st2.peek();
            if((top1.data + top2.data) == x){
                count ++;
                st1.pop();
                st2.pop();
                root1 = top1.right;
                root2 = top2.left;
            } else if((top1.data + top2.data) < x){
                st1.pop();
                root1 = top1.right;
            } else{
                st2.pop();
                root2 = top2.left;
            }
        }
        return count;
    } //O(n)
}
