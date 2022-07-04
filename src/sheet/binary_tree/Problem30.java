package sheet.binary_tree;

import java.util.ArrayList;

public class Problem30 {
    private int helper(Node root, int k, ArrayList<Integer> path) {
        //base case
        if(root == null) {
            return 0;
        }
        //add root to path
        path.add(root.data);
        //check if current path equals to sum k
        int sum = 0, res = 0;
        for(int i=path.size()-1; i>=0; i--) {
            sum += path.get(i);
            if(sum == k) {
                res++;
            }
        }
        //recursive call for left sub-tree
        int left = helper(root.left, k, path);
        //recursive call for right sub-tree
        int right = helper(root.right, k, path);
        //backtrack -> remove root node data from path
        path.remove(path.size()-1);
        return (left + right + res);
    }

    public int sumK(Node root, int k) {
        //remember -> path is created in Heap, will not change will recursive calls
        //have to change it manually
        ArrayList<Integer> path = new ArrayList<>();
        return helper(root, k, path);
    }
}
