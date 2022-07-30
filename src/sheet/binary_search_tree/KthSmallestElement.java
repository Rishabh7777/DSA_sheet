package sheet.binary_search_tree;

import java.util.ArrayList;

public class KthSmallestElement {
    private void getInOrder(Node root, ArrayList<Integer> inOrder) {
        if(root == null) {
            return;
        }
        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }

    public int sol(Node root, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        getInOrder(root, list);
        for(int i=1; i<=list.size(); i++) {
            if(i == K) {
                return list.get(i - 1);
            }
        }
        return -1;
    }
}
